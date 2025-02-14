package com.example.chap02;

import java.io.IOException;
import java.util.Scanner;

public class exam01 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액을 입력하세요...: ");
		int money = Integer.parseInt(sc.nextLine());
		
		// 잔액이 최소 금액(200) 보다 클 때 실행
		while(money >= 200) {
			// 메뉴 선택 여부 -> Y: 진행 | N: 프로그램 종료 | 그 외: 다시 입력
			System.out.print("메뉴를 선택하시겠습니까? (Y/N) ");
			String answer = sc.nextLine();
			if (answer.equals("N")) {
				System.out.println("주문을 종료합니다.");
				System.exit(0);
			} else if (!answer.equals("Y")) {
				continue;
			}
			
			// 메뉴 선택
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 커피(200원)");
			System.out.println("2. 율무차(300원)");
			System.out.println("3. 라떼(500원)");
			System.out.println("4. 녹차(400원)");
			
			int menu = Integer.parseInt(sc.nextLine());
			int price;
			switch (menu) {
				case 1: price = 200; break;
				case 2: price = 300; break;
				case 3: price = 500; break;
				case 4: price = 400; break;
				default: price = 0; break;
			}
			
			// 잔액이 충분하지 않은 경우, 메뉴 선택 재진행
			if (price == 0 || money < price) {
				System.out.println("주문에 실패했습니다.");
				continue;
			}
			
			// 잔액이 충분한 경우, 결제 진행
			money -= price;
			switch (menu) {
				case 1:
					System.out.printf("커피를 주문했습니다. 남은 금액: %d\n", money);
					break;
				case 2:
					System.out.printf("율무차를 주문했습니다. 남은 금액: %d\n", money);
					break;
				case 3:
					System.out.printf("라뗴를 주문했습니다. 남은 금액: %d\n", money);
					break;
				case 4:
					System.out.printf("녹차를 주문했습니다. 남은 금액: %d\n", money);
					break;
				default: break;
			}
		}
		
		// 잔액이 최소 금액(200) 보다 작으면 프로그램 종료
		System.out.println("잔액이 부족합니다.\n주문을 종료합니다.");
		sc.close();
	}
}