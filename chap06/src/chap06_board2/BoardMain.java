package chap06_board2;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
			BoardJob boardJob = new BoardJob();
			boardJob.temp();
			
			Scanner sc = new Scanner(System.in);
			
			Board board;
			String job;
			
			while(true) {
				board = boardJob.selectMenu(sc);
				job = boardJob.selectJob(sc);
				
				switch (job) {
					case "1":
						PostBasic post = boardJob.createPost(sc, board);
						boardJob.registerPost(post);
				}
			}
	}

}
