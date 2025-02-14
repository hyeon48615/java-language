package com.example.chap02;

public class chap02 {
	
	public static void main(String[] args) {
		// TODo Auto-generated method stub
		
		// boolean b1 = true;
		// char a1 = 'a';
		
		short s1 = 1000;
		int a2 = 1000;
		long a3 = 1000L;
		float f1 = 10.0F;
		double d1 = 1.0D;
		
		// 사이즈가 작은 것을 사이즈가 큰 것에 넣는 것 -> 정상 동작
		// 자동 형변환(암묵적 형변환)
		a2 = s1;
		a3 = a2;
		d1 = f1;
		
		// 사이즈 큰 것을 사이즈가 작은 것에 넣는 것 -> 오류
		// s1 = a2; //cannot convert from int to short
		// 강제 형변환(명시적 형변환)
		// 캐스팅 연산 이용. 다운사이징
		// 작은값 = (작은타입형)큰값;
		s1 = (short)a2; 
		
		// 값이 더 큰 경우, 시스템이 임의의 숫자로 잘라서 대입
		int a4 = 1000000;
		s1 = (short)a4;
		
		System.out.println(s1); // -> 16960
		
		// 자료형이 다른 두 변수의 연산
		int t1 = 0;
		t1 = a2 + (int)a3; // 다운사이징 시, 값의 범위 주의
		System.out.println(t1);
		
		double t2 = 0;
		// (int)t2 = a2; // Syntax Error
		
		// 기본타입 허용 범위 순서
		// byte < short < int < long < float < double
		
		// + 연산자
		// 수치 자료형 -> 합계 연산
		// 문자형 자료형 -> 문자열을 연결하는 결합 연산
		int b1 = 10;
		float b2 = 10.0F;
		String str1 = "3";
		System.out.println(b1 + b2 + str1); // "20.0" + "3" => "20.03"
		System.out.println(b1 + b2 + Integer.parseInt(str1)); // 23.0
		
		String str2 = "3a";
		// System.out.println(Integer.parseInt(str2)); // NumberFormatException
		
		String str3 = "1000000000000000";
		// System.out.println(Integer.parseInt(str3)); // NumberFormatException 오버 플로우
	}

}