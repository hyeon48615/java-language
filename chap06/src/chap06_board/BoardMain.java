package chap06_board;

import java.util.Scanner;

public class BoardMain  {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BoardJob boardJob = new BoardJob();
		boardJob.createDummy();
		
		Board board;
		String job;
		while(true) {
			board = boardJob.selectMenu(sc);
			job = boardJob.selectJob(sc);
			
			switch(job) {
				case "1":
					System.out.println(board.getName() + " >> 1. 등록을 선택하셨습니다.");
					PostBasic post = boardJob.createPost(sc, board);
					boardJob.registerPost(post);
					break;
				case "2":
					System.out.println(board.getName() + " >> 2. 목록 출력을 선택하셨습니다.");
					boardJob.printPostList(sc, board);
					break;
				case "99":
					continue;
			}
		}
	}
}
