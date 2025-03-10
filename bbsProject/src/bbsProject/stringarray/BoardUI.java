package bbsProject.stringarray;

import java.util.Scanner;

public class BoardUI {

	private BoardUI() {
	}

	public BoardUI(Scanner sc) {
		this.sc = sc;
	}

	private Scanner sc;

	private Board curBoard;
	private BoardInterface boardJob;

	int pageNo = 1;
	int pageSize = 3;
	int pageBlockSize = 5;

	public void start() {
		while (true) {
			curBoard = selectBoard();
			if (curBoard == null) {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			boardJob = curBoard.getBoardJob();
			boardJob.setPageNation(pageNo, pageSize, pageBlockSize, 0);
			selectJob();
		}
	}

	private Board selectBoard() {
		System.out.printf("%25.25s\n", "main " + "-".repeat(25));
		System.out.println("1. 일반 게시판\n2. 이벤트 게시판\n3. 공지사항 게시판\n99. 종료");
		System.out.println("-------------------------");

		String input;
		do {
			System.out.print("선택: ");
			input = sc.nextLine();
		} while (!input.matches("1|2|3|99"));

		switch (input) {
		case "1":
			return Board.BASIC;
		case "2":
			return Board.EVENT;
		case "3":
			return Board.NOTICE;
		}
		return null;
	}

	private void selectJob() {
		while (true) {
			System.out.printf("%25.25s\n", curBoard.getNameUs() + " " + "-".repeat(25));
			System.out.println("1. 등록\n2. 검색\n3. 목록 출력\n99. 이전 메뉴");
			System.out.println("-------------------------");

			String input;
			do {
				System.out.print("선택: ");
				input = sc.nextLine();
			} while (!input.matches("1|2|3|99"));

			switch (input) {
			case "1":
				String[] post = registerPost();
				boardJob.regist(post);
				break;
			case "2":
				System.out.print("# 카테고리(TITLE, CONTENT): ");
				String category = sc.nextLine();
				System.out.print("# 검색어: ");
				String keyword = sc.nextLine();
				printPostList(category, keyword);
				break;
			case "3":
				printPostList(null, null);
				break;
			case "99":
				System.out.println(">> 게시판 선택화면으로 이동합니다.");
				return;
			}
		}
	}

	private String[] registerPost() {
		System.out.println("# 데이터를 입력하세요");
		String[] fields = curBoard.getFields();
		String[] post = new String[fields.length];

		for (int i = 1; i < fields.length; i++) {
			System.out.print(fields[i] + ": ");
			post[i] = sc.nextLine();
		}

		return post;
	}

	private void printPostList(String category, String keyword) {
		while(true) {
			// 1. 목록 출력
			String[][] posts;
			if(category != null) {
				posts = boardJob.search(category, keyword);
				if (posts == null || posts.length == 0) {
					category = null; 
					keyword = null;
				}
			} else {
				posts = boardJob.retrieve();
			}
			viewPosts(posts);
			
			if (posts == null || posts.length == 0) {
				return;
			}
			
			// 2. 페이지네이션 영역 출력
			boardJob.printPageArea();
			
			// 3. 메뉴 출력
			System.out.println("-------------------------");
			System.out.printf("1. 게시글 조회\n2. 게시글 수정\n3. 게시글 삭제\n99. 이전 메뉴\n");
			System.out.println("[페이지 조작법]");
			System.out.printf("<<\t: 첫페이지로 이동\n<\t: 이전 %d개\npage\t: 페이지로 이동\n>\t: 다음 %d개\n>>\t: 마지막 페이지\n", pageBlockSize, pageBlockSize);
			
			String input;
			do {
				System.out.print("선택: ");
				input = sc.nextLine();
			} while(!input.matches("1|2|3|99|<<|<|page|>|>>"));
			
			switch(input) {
				// 게시글 조작 기능
				case "1":
					System.out.print("# 게시글 번호: ");
					String[] post = boardJob.retrieveDetail(sc.nextLine());
					viewPostDetail(post);
					break;
				case "2":
					System.out.print("# 게시글 번호: ");
					String no = sc.nextLine();	
					String[] newPost = registerPost();
					boardJob.modify(no, newPost);
					break;
				case "3":
					System.out.print("# 게시글 번호: ");
					boardJob.delete(sc.nextLine());
					break;
					
				// 페이지네이션	
				case "<<": 
					boardJob.moveToFirstPage(); 
					break;
				case "<":
					boardJob.moveLeft();
					break;
				case "page":
					try {
						System.out.print("# 페이지 번호: ");
						int page = Integer.parseInt(sc.nextLine());
						boardJob.moveToPage(page);
						break;
					} catch(Exception e) {
						System.out.println("잘못된 입력입니다.");
						break;
					}
				case ">":
					boardJob.moveRight();
					break;
				case ">>":
					boardJob.moveToLastPage();
					break;
				case "99":
					boardJob.setPageNation(pageNo, pageSize, pageBlockSize, 0);
					System.out.println(">> 업무 선택화면으로 이동합니다.");
					return;
			}
		
		}

	}

	private void viewPosts(String[][] posts) {
		System.out.println(">> " + curBoard.getNameKr() + " 목록을 조회합니다.");

		// header
		String str = "", line = "";
		String[] fields = curBoard.getFields();
		str = getFormattedPost(fields);
		line = "-".repeat(MyFormatter.getByteLength(str));

		System.out.println(str);
		System.out.println(line);

		// data
		if (posts == null || posts.length == 0) {
			System.out.println("게시글이 없습니다.");
			return;
		}

		for (String[] p : posts) {
			System.out.println(getFormattedPost(p));
		}
	}
	
	private void viewPostDetail(String[] post) {
		System.out.printf("%25.25s\n", "no." + post[0] + " post " + "~".repeat(25));
		for(String p : post) {
			System.out.println(p);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	private String getFormattedPost(String[] post) {
		String str = "";

		str += MyFormatter.getFormatStr(post[0], 10) + " "; // no
		str += MyFormatter.getFormatStr(post[1], 30) + " "; // title
		str += MyFormatter.getFormatStr(post[3], 20) + " "; // name
		str += MyFormatter.getFormatStr(post[5], 20) + " "; // regDate

		if (post.length > 6) {
			str += MyFormatter.getFormatStr(post[6], 10) + " "; // 추가 필드
		}

		return str;
	}

}
