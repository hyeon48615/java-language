package bbsProject.stringarray;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardUI boardUI = new BoardUI(sc);
		boardUI.start();
	}

}
