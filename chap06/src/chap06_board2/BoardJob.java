package chap06_board2;

import java.util.Scanner;

public class BoardJob {
	private PostBasic[] basicList = new PostBasic[0];
	private PostEvent[] eventList = new PostEvent[0];
	private PostNotice[] noticeList = new PostNotice[0];
	
	private int page = 1;
	private int offset = 3; // 한 페이지에 표시할 게시글 수
	private int pageOffset = 5; // 한 번에 표시할 페이지 수
	
	// 더미 데이터 생성 메서드
	public void temp() {
		for(int i=0; i<100; i++) {
			int random = (int)(Math.random()*100);
			if(i%2==0) {
				PostBasic post = new PostBasic("basic - title"+random, "name", "regDate");
			} else if (i%3==0) {
				PostEvent post = new PostEvent("event - title"+random, "name", "regDate", "eventDate");
			} else {
				PostNotice post = new PostNotice("notice - title"+random, "name", "regDate", "noticeFile");
			}
		}
		System.out.println("더미 데이터 생성 완료\n");
	}
	
	// 게시판 선택 메서드
	public Board selectMenu(Scanner sc) {
		String menu = "";
		Board board = null;
		
		System.out.println("게시판을 선택하세요");
		System.out.println("1. 게시판\n2. 이벤트 게시판\n3. 공지사항 게시판\n99. 종료");
		
		do {
			System.out.print("선택: ");
			menu = sc.nextLine();
		} while(!menu.matches("1|2|3|99"));
		
		switch(menu) {
			case "1": board = Board.BASIC; break;
			case "2": board = Board.EVENT; break;
			case "3": board = Board.NOTICE; break;
			case "99":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
		}
		
		System.out.println(">> " + Color.blue + board.getName() + Color.reset + "을[를] 선택하셨습니다.");
		
		return board;
	}

	// 업무 선택 메서드
	public String selectJob(Scanner sc) {
		String job = "";
		
		System.out.println("진행할 업무를 선택하세요");
		System.out.println("1. 등록\n2. 목록 출력\n99. 이전 메뉴");
		
		do {
			System.out.print("선택: ");
			job = sc.nextLine();
		} while(!job.matches("1|2|99"));
		
		return job;
	}

	// 게시글 생성 메서드
	public PostBasic createPost(Scanner sc, Board board) {
		System.out.println("데이터를 입력하세요");
		
		String[] column = board.getColumn();
		String[] values = new String[column.length];
		for(int i=0; i<column.length; i++) {
			System.out.print(column[i] + ": ");
			values[i] = sc.nextLine();
		}
		
		PostBasic post;
		if(board == Board.BASIC) {
			post = new PostBasic(values[0], values[1], values[2]);
		} else if (board == Board.EVENT) {
			post = new PostEvent(values[0], values[1], values[2], values[3]);
		} else if (board == Board.NOTICE) {
			post = new PostNotice(values[0], values[1], values[2], values[3]);
		} else {
			return null;
		}
		return post;
	}
	
	// 게시글 등록 메서드
	public void registerPost(PostBasic post) {
		if(post instanceof PostEvent) {
			PostEvent[] newList = new PostEvent[eventList.length + 1];
			System.arraycopy(eventList, 0, newList, 0, eventList.length);
			newList[newList.length-1] = (PostEvent)post;
			eventList = new PostEvent[newList.length];
			System.arraycopy(newList, 0, eventList, 0, newList.length);
		} else if (post instanceof PostNotice) {
			PostNotice[] newList = new PostNotice[noticeList.length + 1];
			System.arraycopy(noticeList, 0, newList, 0, noticeList.length);
			newList[newList.length-1] = (PostNotice)post;
			noticeList = new PostNotice[newList.length];
			System.arraycopy(newList, 0, noticeList, 0, newList.length);
		} else {
			PostBasic[] newList = new PostBasic[basicList.length + 1];
			System.arraycopy(basicList, 0, newList, 0, basicList.length);
			newList[newList.length-1] = (PostBasic)post;
			basicList = new PostBasic[newList.length];
			System.arraycopy(newList, 0, basicList, 0, newList.length);
		}
		System.out.println("등록이 완료되었습니다.");
	}
	
	// 데이터 포맷 메서드
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

	// 게시글 목록 출력 메서드
	public void printPostList(Board board) {
		
	}
	
}
