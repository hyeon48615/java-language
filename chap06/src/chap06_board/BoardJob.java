package chap06_board;

import java.util.Scanner;

public class BoardJob {
	
	public BoardJob() {}
	
	private PostBasic[] postList = new PostBasic[0];
	
	private int idx = 1;
	private int postCnt = 0;
	
	private int page = 1;
	private int offset = 3; // 한 페이지에 표시할 게시글 수
	private int pageOffset = 5; // 한 번에 표시할 페이지 수
	
	// 더미 데이터 생성 메서드
	public void createDummy() {
		for(int i=1; i<=100; i++) {
			if(i%2==0) {
				PostBasic post = new PostBasic(i,"title"+i, "name", "regDate");
				registerPost(post);
			} else if (i%3==0) {
				PostEvent post = new PostEvent(i,"title"+i, "name", "regDate", "eventDate");
				registerPost(post);
			} else {
				PostNotice post = new PostNotice(i,"title"+i, "name", "regDate", "noticeFile");
				registerPost(post);
			}
		}
	}
	
	// 메뉴 출력 메서드
	public Board selectMenu(Scanner sc) {
		String menu = "";
		Board board = null;
		
		System.out.println("게시판을 선택하세요:");
		System.out.println("게시판");
		System.out.println("---------------");
		System.out.println("1. 게시판\n2. 이벤트 게시판\n3. 공지사항 게시판\n99. 종료");
		
		while(true) {
			System.out.print("선택: ");
			menu = sc.nextLine();
			
			if(menu.equals("1") || menu.equals("2") || menu.equals("3") || menu.equals("99")) {
				break;
			} 
		}
		
		switch(menu) {
			case "1": board = Board.BASIC; break;
			case "2": board = Board.EVENT; break;
			case "3": board = Board.NOTICE; break;
			case "99":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
		}
		
		System.out.println(board.getName() + "을 선택하셨습니다.");
		
		return board;
	}

	// 업무 출력 메서드
	public String selectJob(Scanner sc) {
		String job = "";
		
		System.out.println("진행할 업무를 선택하세요:");
		System.out.println("1. 등록\n2. 목록 출력\n99. 이전 메뉴");
	
		while(true) {
			System.out.print("선택: ");
			job = sc.nextLine();
			
			if(job.equals("1") || job.equals("2") || job.equals("99")) {
				break;
			}
		}
		
		return job;
	}

	// 게시글 생성 메서드
	public PostBasic createPost(Scanner sc, Board board) {
		System.out.println("데이터를 입력하세요... : ");
		
		PostBasic post = null;
		String title = "", name = "", regDate = "";
		
		System.out.print("1. 제목: ");
		title = sc.nextLine();
		
		System.out.print("2. 이름: ");
		name = sc.nextLine();
		
		System.out.print("3. 등록일: ");
		regDate = sc.nextLine();
		
		if(board == Board.BASIC) {
			post = new PostBasic(idx, title, name, regDate);
		}
		else if(board == Board.EVENT) {
			System.out.print("4. 이벤트 날짜: ");
			String eventDate = sc.nextLine();
		
			post = new PostEvent(idx, title, name, regDate, eventDate);
		}
		else if(board == Board.NOTICE) {
			System.out.print("5. 첨부파일명: ");
			String noticeFile = sc.nextLine();
			
			post = new PostNotice(idx, title, name, regDate, noticeFile);
		}
		
		return post;
	}

	// 게시글 등록 메서드
	public void registerPost(PostBasic post) {
		PostBasic[] newList = new PostBasic[postCnt+1];
		System.arraycopy(postList, 0, newList, 0, postList.length);
		newList[newList.length-1] = post;
		postList = new PostBasic[postCnt+1];
		System.arraycopy(newList, 0, postList, 0, newList.length);
		System.out.println("등록이 완료되었습니다. 게시글 번호: " + idx);
		postCnt++;
		idx++;
	}
	
	// 게시글 목록 출력 메서드
	public void printPostList(Scanner sc, Board board) {
		while(true) {
			// header
			String str = "", line = "";
			if(board == Board.BASIC) { str = getFormattedData("No.", "제목", "이름", "등록일");	}
			else if(board == Board.EVENT) { str = getFormattedData("No.", "제목", "이름", "등록일", "이벤트 날짜"); }
			else if(board == Board.NOTICE) { str = getFormattedData("No.", "제목", "이름", "등록일", "첨부파일명"); }
					
			line = "-".repeat(getByteLength(str));
			System.out.println(str);
			System.out.println(line);
					
			// data
			PostBasic[] posts = getPostListByBoard(board);
			if(posts == null || posts.length == 0) {
				System.out.println("게시글이 없습니다.");
				return;
			} 
			getPostListByPage(posts, board);
			System.out.println(line);
			
			boolean exit = selectPostMenu(sc, posts);
			if(exit) break;
		}
	}

	// 페이지네이션 출력 메서드
	public boolean selectPostMenu(Scanner sc, PostBasic[] posts) {
		// pagination-btn
		int totalPage = Math.ceilDiv(posts.length, offset);
		int startPage = Math.floorDiv(page-1, pageOffset) * pageOffset + 1;
		int lastPage = startPage + pageOffset - 1;
		if(lastPage > totalPage) { lastPage = totalPage; }
		
		System.out.print("<< < ");
		for(int i=startPage; i<=lastPage; i++) { 
			if(i == page) { System.out.printf("\u001B[31m%d \u001B[0m", i); }
			else { System.out.printf("%d ", i); }
		}
		System.out.println("> >>");
		
		// 메뉴 출력
		String menu = "";
		System.out.printf("1. 첫페이지로 이동\n2. 이전 %d개\n3. 페이지로 이동\n4. 다음 %d개\n5. 마지막 페이지\n", pageOffset, pageOffset);
		System.out.println("---------------");
		System.out.printf("a. 게시글 조회\nb. 게시글 수정\nc. 게시글 삭제\nd. 이전 메뉴\n");
		
		while(true) {
			System.out.print("선택: ");
			menu = sc.nextLine();
			
			switch(menu) {
				case "1": 
					page = 1;
					return false;
				case "2": 
					page -= pageOffset;
					if (page < 1) { page = 1; }
					return false;
				case "3": 
					System.out.print("페이지를 입력하세요: ");
					try {
						int pagination = Integer.parseInt(sc.nextLine());
						if(pagination >= 1 && pagination <= totalPage) {
							page = pagination;
							return false;
						} else {
							System.out.println("잘못된 페이지입니다.");
							continue;
						}
					} catch(Exception e) {
						System.err.println("잘못된 입력입니다.");
						continue;
					}
				case "4": 
					page += pageOffset;
					if (page > totalPage) { page = totalPage; }
					return false;
				case "5":
					page = totalPage;
					return false;
				case "a":
					System.out.print("게시글 번호를 입력하세요: ");
					try {
						int no = Integer.parseInt(sc.nextLine());
						int result = getPostDetail(no);
						if(result != -1) printPostDetail(result);
						return false;
					} catch(Exception e) {
						System.err.println("잘못된 입력입니다.");
						continue;
					}
				case "b":
					System.out.print("게시글 번호를 입력하세요: ");
					try {
						int no = Integer.parseInt(sc.nextLine());
						updatePost(sc, no);
						return false;
					} catch(Exception e) {
						System.err.println("잘못된 입력입니다.");
						continue;
					}
				case "c":
					System.out.print("게시글 번호를 입력하세요: ");
					try {
						int no = Integer.parseInt(sc.nextLine());
						deletePost(no);
						return false;
					} catch(Exception e) {
						System.err.println("잘못된 입력입니다.");
						continue;
					}
				case "d":
					return true;
				default:
					continue;
			}
		}
	}
	
	// 게시글 조회 메서드 - 게시판 별 게시글
	public PostBasic[] getPostListByBoard(Board board) {
		int iterator = 0;
		PostBasic[] searchPosts = new PostBasic[postCnt];
		
		for(PostBasic post : postList) {
			if((board == Board.BASIC)
				|| (board == Board.EVENT && post instanceof PostEvent)
				|| (board == Board.NOTICE && post instanceof PostNotice)) {
				searchPosts[iterator] = post;
				iterator++;
			}
		}
		
		PostBasic[] resultPosts = new PostBasic[iterator];
		System.arraycopy(searchPosts, 0, resultPosts, 0, resultPosts.length);
		return resultPosts;
	}
	
	// 게시글 조회 메서드 - 게시판 별 게시글을 페이지네이션한 결과
	public void getPostListByPage(PostBasic[] posts, Board board) {
		String str = "";
		
		int startIndex = offset * (page-1);
		int lastIndex = (startIndex + offset > posts.length) ? posts.length - 1 : startIndex + offset - 1;
				
		for(int i=startIndex; i <= lastIndex; i++) {
			PostBasic post = posts[i];
			
			switch(board) {
				case Board.BASIC:
					str = getFormattedData(String.valueOf(post.getIdx()), post.getTitle(), post.getName(), post.getRegDate());
					break;
				case Board.EVENT: 
					PostEvent event = (PostEvent)post; 
					str = getFormattedData(String.valueOf(event.getIdx()), event.getTitle(), event.getName(), event.getRegDate(), event.getEventDate());
					break;
				case Board.NOTICE: 
					PostNotice notice = (PostNotice)post; 
					str = getFormattedData(String.valueOf(notice.getIdx()), notice.getTitle(), notice.getName(), notice.getRegDate(), notice.getNoticeFile());
					break;
			}
			System.out.println(str);
		}
	}

	private String getFormattedData(String idx, String title, String name, String regDate, String ... fields) {
		String str = "";
		
		str += getFormatStr(idx, 10) + " ";
		str += getFormatStr(title, 30) + " ";
		str += getFormatStr(name, 20) + " ";
		str += getFormatStr(regDate, 20) + " ";
		
		for(String f : fields) {
			str += getFormatStr(f, 20) + " ";
		}
		
		return str;
	}
	
	// 특정 게시글 조회 메서드 - 인덱스 반환
	// 특정 게시글 조회 메서드
	public int getPostDetail(int no) {
		for(int i=0; i<postList.length; i++) {
			PostBasic post = postList[i];
			if(post.idx == no) {
				return i;
			}
		}
		System.out.println("해당 게시글이 없습니다: " + no);
		return -1;
	}

	// 특정 게시글 출력 메서드
	public void printPostDetail(int index) {
		PostBasic post = postList[index];
		
		System.out.println("1. 제목: " + post.getTitle());
		System.out.println("2. 이름: " + post.getName());
		System.out.println("3. 등록일: " + post.getRegDate());

		if(post instanceof PostEvent) {
			PostEvent postEvent = (PostEvent)post;
			System.out.print("4. 이벤트 날짜: " + postEvent.getEventDate());
		}
		else if(post instanceof PostNotice) {
			PostNotice postNotice = (PostNotice)post;
			System.out.print("5. 첨부파일명: " + postNotice.getNoticeFile());
		}
	}
	
	// 특정 게시글 수정 메서드
	public void updatePost(Scanner sc, int no) {
		int index = getPostDetail(no);
		PostBasic post = postList[index];
		
		Board board = Board.BASIC;
		if(post instanceof PostEvent) {
			board = Board.EVENT;
		}
		else if(post instanceof PostNotice) {
			board = Board.NOTICE;
		}
		
		int tmp_idx = idx;
		idx = index;
		PostBasic newPost = createPost(sc, board);
		postList[index] = newPost;
		
		idx = tmp_idx;
		
		System.out.println("게시글 수정이 완료되었습니다.");
	}

	// 특정 게시글 삭제 메서드
	public void deletePost(int no) {
		int index = getPostDetail(no);

		for(int i=index; i<postList.length-1; i++) {
			postList[i] = postList[i+1];
		}
		
		PostBasic[] newList = new PostBasic[postCnt-1];
		System.arraycopy(postList, 0, newList, 0, postList.length - 1);
		
		postList = new PostBasic[postCnt-1];
		System.arraycopy(newList, 0, postList, 0, newList.length);
		
		System.out.println("게시글 삭제가 완료되었습니다.");
		postCnt--;
	}
	
	// 한글 포맷팅 오류 해결 -> 글꼴 D2Coding
	public static int getByteLength(String str) {
		int length = 0;
		if(str != null) {
			try {
				length = str.getBytes("euc-kr").length;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return length;
	}
	
	public static String getFormatStr(String str, int size) {
		int strByte = getByteLength(str);
		
		// 경우1) str이 size 보다 크면 문자열 자른후 반환
		if(strByte > size) {
			int sum = 0, index = 0;
			for(int i=0; i<str.length(); i++) {
				String ch = str.substring(i, i+1);
				sum += getByteLength(ch);
							
				if(sum == size) { index = ++i; break; }
				else if(sum > size) { index = i; break; }
			}
			return str.substring(0, index);
		}
		// 경우2) str이 size 보다 작으면 공백을 채워 반환
		else {
			int d = size - (getByteLength(str) - str.length());
			return String.format("%-" + d + "s", str);
		}
	}
}
