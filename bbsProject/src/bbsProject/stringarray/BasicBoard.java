package bbsProject.stringarray;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;

public class BasicBoard implements BoardInterface {

	public BasicBoard() {
	}
	
	public BasicBoard(int size) {
		boardList = new String[size][];
		for (int i=1; i<=size; i++) {
			LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
			boardList[i - 1] = new String[] { String.valueOf(this.no), "제목" + i, "내용" + i
					, "user" + i, "user" + i + "@www.com"
					, String.valueOf(now.plusDays(i)) };
			this.no++;
		}
	}

	public BasicBoard(int pageNo, int pageSize, int pageBlockSize) {
		this.setPageSize(pageSize);
		this.setPageNo(pageNo);
		this.setTotalCount(this.boardList.length);
		this.setTotalPageNo();
		this.setPageSkipCount();
		this.setPageBlockSize(pageBlockSize);
		this.setPageBlockStart();
		this.setPageBlockEnd();
	}

	private int pageNo; // 현재 페이지
	private int totalCount; // 총 데이터 개수
	private int pageSize; // 한 페이지에 보여줄 데이터 개수

	private int totalPageNo; // 총 페이지 수
	private int pageSkipCount; // 스킵한 페이지 개수

	private int pageBlockSize; // 한 번에 보여질 페이지 블럭의 개수
	private int pageBlockStart; // 페이지 블럭 시작점
	private int pageBlockEnd; // 페이지 블럭 끝점

	private boolean prevPageFlag; // 이전 페이지 블럭 존재 여부
	private boolean nextPageFlag; // 이후 페이지 블럭 존재 여부

	public int getPageNo() {
		return this.pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageNo() {
		return this.totalPageNo;
	}

	public void setTotalPageNo() {
		this.totalPageNo = (int) Math.ceil(this.totalCount / (float) this.pageSize);
	}

	public int getPageSkipCount() {
		return this.pageSkipCount;
	}

	public void setPageSkipCount() {
		this.pageSkipCount = (this.pageNo - 1) * this.pageSize;
	}

	public int getPageBlockSize() {
		return this.pageBlockSize;
	}

	public void setPageBlockSize(int pageBlockSize) {
		this.pageBlockSize = pageBlockSize;
	}

	public int getPageBlockStart() {
		return this.pageBlockStart;
	}

	public void setPageBlockStart() {
		this.pageBlockStart = (int) Math.floor((this.pageNo - 1) / (float) this.pageBlockSize) * this.pageBlockSize + 1;
	}

	public int getPageBlockEnd() {
		return this.pageBlockEnd;
	}

	public void setPageBlockEnd() {
		this.pageBlockEnd = (int) Math.ceil(this.pageNo / (float) this.pageBlockSize) * this.pageBlockSize;
		this.pageBlockEnd = Math.min(this.pageBlockEnd, this.totalPageNo);
	}

	public boolean isPrevPageFlag() {
		return (this.pageBlockStart > 1);
	}

	public void setPrevPageFlag() {
		this.prevPageFlag = (this.pageBlockStart > 1);
	}

	public boolean isNextPageFlag() {
		return this.nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = (this.pageNo > this.pageBlockEnd);
	}

	private int no = 1;
	private String[][] boardList = {};
	

	public int getNo() {
		return no;
	}

	private void setNo(int no) {
		this.no = no;
	}

	public String[][] getBoardList() {
		return boardList;
	}

	private void setBoardList(String[][] boardList) {
		this.boardList = boardList;
	}

	@Override
	public void regist(String[] arrInput) {
		// no auto-increment 처리
		arrInput[0] = String.valueOf(no++);

		// boardList 에 추가
		String[][] newList = new String[boardList.length + 1][];
		System.arraycopy(boardList, 0, newList, 0, boardList.length);
		newList[newList.length - 1] = arrInput;
		boardList = new String[newList.length][];
		System.arraycopy(newList, 0, boardList, 0, newList.length);

		this.setPageNation(this.pageNo, this.pageSize, this.pageBlockSize, boardList.length);
	}

	@Override
	public void modify(String no, String[] arrInput) {
		for(int i=0; i<boardList.length; i++) {
			if (boardList[i][0].equals(no)) {
				arrInput[0] = no;
				boardList[i] = arrInput;
			}
		}
	}

	@Override
	public void delete(String no) {
		String[][] newList = new String[boardList.length-1][];
		
		int idx = 0;
		for(int i=0; i<boardList.length; i++) {
			if (!boardList[i][0].equals(no)) {
				newList[idx++] = boardList[i];
			}
		}
		setBoardList(newList);
		
		this.setPageNation(this.pageNo, this.pageSize, this.pageBlockSize, this.boardList.length);
	}

	@Override
	public String[][] retrieve() {
		int startIdx = getPageSkipCount();
		int lastIdx = (startIdx + pageSize > boardList.length) ? boardList.length : startIdx + pageSize;
		
		String[][] newList = new String[lastIdx - startIdx][];
		int idx = 0;
		for (int i = startIdx; i < lastIdx; i++) {
			newList[idx++] = boardList[i];
		}

		return newList;
	}

	@Override
	public String[] retrieveDetail(String no) {
		for(int i=0; i<boardList.length; i++) {
			if (boardList[i][0].equals(no)) {
				return boardList[i];
			}
		}
		return null;
	}
	
	@Override
	public String[][] search(String category, String keyword) {
		String[][] searchList = new String[boardList.length][];
		
		int col;
		switch (category) {
			case "TITLE": col = 1; break;
			case "CONTENT": col = 2; break;
			default: return null;
		}
		
		int searchIdx = 0;
		for(String[] post : boardList) {
			if(post[col].contains(keyword)) {
				searchList[searchIdx++] = post;
			} 
		}
		
		// searchList.length == searchIdx
		this.setPageNation(this.pageNo, this.pageSize, this.pageBlockSize, searchIdx);
		
		int startIdx = getPageSkipCount();
		int lastIdx = (startIdx + pageSize > searchIdx) ? searchIdx : startIdx + pageSize;
		
		String[][] newList = new String[lastIdx - startIdx][];
		int newIdx = 0;
		for (int i = startIdx; i < lastIdx; i++) {
			newList[newIdx++] = searchList[i];
		}
		
		return newList;
	}

	@Override
	public void printPageArea() {
		int startPage = this.getPageBlockStart();
		int lastPage = this.getPageBlockEnd();

		System.out.print("<< < ");
		for (int i = startPage; i <= lastPage; i++) {
			if (i == pageNo) {
				System.out.printf("[%d] ", i);
			} else {
				System.out.printf("%d ", i);
			}
		}
		System.out.println("> >>");
	}

	@Override
	public void setPageNation(int pageNo, int pageSize, int pageBlockSize, int totalCount) {
		this.setPageNo(pageNo);
		this.setPageSize(pageSize);
		this.setPageBlockSize(pageBlockSize);
		if(totalCount == 0) {
			this.setTotalCount(this.boardList.length);
		} else {
			this.setTotalCount(totalCount);
		}
		this.setTotalPageNo();
		this.setPageSkipCount();
		this.setPageBlockStart();
		this.setPageBlockEnd();
	}

	@Override
	public void moveToFirstPage() {
		this.setPageNation(1, pageSize, pageBlockSize, totalCount);
	}

	@Override
	public void moveToLastPage() {
		this.setPageNation(totalPageNo, pageSize, pageBlockSize, totalCount);
	}

	@Override
	public void moveLeft() {
		int page = pageNo - pageBlockSize;
		if (page < 1)
			page = 1;
		this.setPageNation(page, pageSize, pageBlockSize, totalCount);
	}

	@Override
	public void moveRight() {
		int page = pageNo + pageBlockSize;
		if (page > totalPageNo)
			page = totalPageNo;
		this.setPageNation(page, pageSize, pageBlockSize, totalCount);
	}

	@Override
	public void moveToPage(int pageNo) {
		if (pageNo >= 1 && pageNo <= this.totalPageNo) {
			this.setPageNation(pageNo, pageSize, pageBlockSize, totalCount);
		} else {
			System.out.println("해당 페이지가 없습니다.");
		}
	}
}
