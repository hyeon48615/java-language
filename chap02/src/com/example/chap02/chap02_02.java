package com.example.chap02;

// import java.util.*;
import java.util.Scanner;

public class chap02_02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// print 문
		System.out.print("출력 후 커서를 문의 끝에 둡니다.");
		
		// println
		System.out.println("출력 후 커서를 한 줄 내려서 맨 앞줄로 이동합니다.");
		
		// printf 문
		int a1 = 10000;
		String str1 = "문자열";
		System.out.printf("문자열 포맷에 맞춰서 출력\n숫자 : %d, 문자 : %s", a1, str1);
		
		// 키보드의 입력값을 읽어들일 때 
		// System.in
		// 키보드 값 읽기, read() -> 한 번에 한 개의 문자만 읽어옴
		int keyCode;
		while(true) {
			keyCode = System.in.read();
			System.out.println("keyCode : "+ keyCode);
			if (keyCode == 97) {
				break;
			}
		}
		
		// Scanner
		// 문자 혹은 문장 단위로 읽어 들일 수 있다.
		Scanner sc = new Scanner(System.in);
		String inData;
		while(true) {
			System.out.println("문자열을 입력하세요 : ");
			inData = sc.nextLine(); // Enter를 입력하면 값을 저장
			// System.out.println("입력 문자열 : \n|"+inData+"|"); // \ : 이스케이프 문자
			if (inData.equals("Q")) {
				break;
			}
		}
		System.out.println("Scan 종료");
	}

}