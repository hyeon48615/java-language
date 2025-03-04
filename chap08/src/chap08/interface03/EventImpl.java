package chap08.interface03;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;

public class EventImpl implements BasicBbsIf {
	public EventImpl() {
	}

	private int pageNo; // 현재 페이지
	private int totalCount; // 총 데이터 개수
	private int pageSize; // 한 페이지에 보여줄 데이터 개수

	private int totalPageNo; // 총 페이지 수
	private int pageSkipCount; // 스킵한 페이지 개수. startIndex

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
		;
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
		this.pageBlockStart = (int) Math.floor(this.pageNo / (float) this.pageBlockSize) * this.pageBlockSize + 1;
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

	private int idx;
	private int no = 1;
	private String searchCategory;
	private String searchWord;
	private String name;
	private String pwd;
	private String userId;
	private String eamil;
	private String title;
	private String content;
	private String regDatge;
	private String displayDate;

	public int getIdx() {
		return this.idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getNo() {
		return this.no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getSearchCategory() {
		return this.searchCategory;
	}

	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}

	public String getSearchWord() {
		return this.searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEamil() {
		return this.eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDatge() {
		return this.regDatge;
	}

	public void setRegDatge(String regDatge) {
		this.regDatge = regDatge;
	}

	public String getDisplayDate() {
		return this.displayDate;
	}

	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}
	
	String[][] arrList = {};

	/*
	String[][] arrList = { { "1", "user1", "1234", "user1@www.com", "제목1", "내용1", "2025-02-01", "2025-02-01" },
			{ "2", "user2", "1234", "user2@www.com", "제목2", "내용2", "2025-02-02", "2025-02-02" },
			{ "3", "user3", "1234", "user3@www.com", "제목3", "내용3", "2025-02-03", "2025-02-03" },
			{ "4", "user4", "1234", "user4@www.com", "제목4", "내용4", "2025-02-04", "2025-02-04" },
			{ "5", "user5", "1234", "user5@www.com", "제목5", "내용5", "2025-02-05", "2025-02-05" },
			{ "6", "user6", "1234", "user6@www.com", "제목6", "내용6", "2025-02-06", "2025-02-06" },
			{ "7", "user7", "1234", "user7@www.com", "제목7", "내용7", "2025-02-07", "2025-02-07" },
			{ "8", "user8", "1234", "user8@www.com", "제목8", "내용8", "2025-02-08", "2025-02-08" },
			{ "9", "user9", "1234", "user9@www.com", "제목9", "내용9", "2025-02-09", "2025-02-09" },
			{ "10", "user10", "1234", "user10@www.com", "제목10", "내용10", "2025-02-10", "2025-02-10" },
			{ "11", "user11", "1234", "user11@www.com", "제목11", "내용11", "2025-02-11", "2025-02-11" },
			{ "12", "user12", "1234", "user12@www.com", "제목12", "내용12", "2025-02-12", "2025-02-12" },
			{ "13", "user13", "1234", "user13@www.com", "제목13", "내용13", "2025-02-13", "2025-02-13" },
			{ "14", "user14", "1234", "user14@www.com", "제목14", "내용14", "2025-02-14", "2025-02-14" },
			{ "15", "user15", "1234", "user15@www.com", "제목15", "내용15", "2025-02-15", "2025-02-15" },
			{ "16", "user16", "1234", "user16@www.com", "제목16", "내용16", "2025-02-16", "2025-02-16" },
			{ "17", "user17", "1234", "user17@www.com", "제목17", "내용17", "2025-02-17", "2025-02-17" },
			{ "18", "user18", "1234", "user18@www.com", "제목18", "내용18", "2025-02-18", "2025-02-18" },
			{ "19", "user19", "1234", "user19@www.com", "제목19", "내용19", "2025-02-19", "2025-02-19" },
			{ "20", "user20", "1234", "user20@www.com", "제목20", "내용20", "2025-02-20", "2025-02-20" } };
	*/

	public void setArrList(String[][] arrList) {
		this.arrList = arrList;
	}

	public String[][] getArrList() {
		return arrList;
	}

	public String[][] createDummy(int size) {
		arrList = new String[size][];
		for (int i = 1; i <= size; i++) {
			LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
			arrList[i - 1] = new String[] { String.valueOf(this.no), "user" + i, "1234", "user" + i + "@www.com",
					"제목" + i, "내용" + i, String.valueOf(now.plusDays(i)), String.valueOf(now.plusDays(i)) };
			this.no++;
		}
		return arrList;
	}

	// 검색된 배열 재생성 및 기존 배열에 복사
	public void searchList() {
		String[][] searchList = new String[arrList.length][];

		int col = 0;
		switch (this.searchCategory) {
		case "TITLE":
			col = 4;
			break;
		case "CONTENTS":
			col = 5;
			break;
		}

		int idx = 0;
		for (int i = 0; i < arrList.length; i++) {
			if (arrList[i][col].contains(searchWord)) {
				searchList[idx] = arrList[i];
				idx++;
			}
		}

		System.out.println("게시물 수: " + idx);

		arrList = new String[idx][];
		System.arraycopy(searchList, 0, arrList, 0, idx);
	}

	// 페이지네이션 영역 출력
	public void printPagingArea() {
		int startPage = this.getPageBlockStart();
		int lastPage = this.getPageBlockEnd();

		System.out.print("<< < ");
		for (int i = startPage; i <= lastPage; i++) {
			if (i == pageNo) {
				System.out.printf("\u001B[36m%d \u001B[0m", i);
			} else {
				System.out.printf("%d ", i);
			}
		}
		System.out.println("> >>");
	}

	// 사용자의 입력을 받아 배열 생성 - Scanner
	public String[] create(Scanner sc) {
		String[] field = { "작성자", "비밀번호", "이메일", "제목", "내용", "작성일", "이벤트날짜"};
		String[] result = new String[field.length];
		int i = 0;
		for(String f : field) {
			System.out.print(f + ": ");
			result[i] = sc.nextLine();
			i++;
		}
		return result;
	}
	
	// 사용자의 입력을 받아 idx 조회
	public int searchIdx(Scanner sc) {
		System.out.print("게시글 번호를 입력하세요. ");
		String no = sc.nextLine();
		for(int i=0; i<arrList.length; i++) {
			if(arrList[i][0].equals(no)) {
				return i;
			}
		}
		System.out.println("잘못된 번호입니다.");
		return -1;
	}
	
	@Override
	public void bbsList(int pageSize, int pageNo, String searchCategory, String searchKeyword) {
		int startIdx = getPageSkipCount();
		int lastIdx = (startIdx + pageSize > arrList.length) ? arrList.length - 1 : startIdx + pageSize - 1;
		System.out.println("글번호\t작성자\t비밀번호\t이메일\t제목\t작성일");
		for (int i = startIdx; i <= lastIdx; i++) {
			System.out.println(this.arrList[i][0] + "\t" + this.arrList[i][1] + "\t" + this.arrList[i][2] + "\t"
					+ this.arrList[i][3] + "\t" + this.arrList[i][4] + "\t" + this.arrList[i][6]);
		}
	}

	@Override
	public void regist(String[] arrInput) {
		// autu_increment 컬럼 추가
		String[] content = new String[arrInput.length + 1];
		content[0] = String.valueOf(this.no);
		int i=1;
		for(String str : arrInput) { content[i] = str; }
		
		// 실제 등록 로직
		String[][] newList = new String[arrList.length + 1][];
		System.arraycopy(arrList, 0, newList, 0, arrList.length);
		newList[newList.length - 1] = content;
		arrList = new String[newList.length][];
		System.arraycopy(newList, 0, arrList, 0, newList.length);
	}

	@Override
	public void view(int bbsIdx) {
		String[] result = this.arrList[bbsIdx];
		System.out.println("글번호\t작성자\t비밀번호\t이메일\t제목\t작성일");
		System.out.println(result[0] + "\t" + result[1] + "\t" + result[2] + "\t"
				+ result[3] + "\t" + result[4] + "\t" + result[6]);
	}
	
	@Override
	public void modify(int bbsIdx, String[] arrInput) {
		for(int i=1; i<arrList[bbsIdx].length; i++) {
			arrList[bbsIdx][i] = arrInput[i-1];
		}
	}

	@Override
	public void delete(int bbsIdx) {
		String[][] newList = new String[arrList.length-1][];
		int index = 0;
		for(int i=0; i<arrList.length; i++) {
			if(i != bbsIdx) {
				newList[index] = arrList[i];
				index++;
			}
		}
		this.setArrList(newList);
	}

}
