package chap10;

import java.util.Scanner;

public class ExceptionMain4 {

	public static void main(String[] args) {
		EA a = new EA();
		try {
			a.input();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("프로그램을 종료합니다.");
		}
		
		// AutoCloseable 객체 구현
		AC a1 = null;
		
		// 1. 일반 try 구문에서 사용 후 finally 에서 리소스 해제
		try {
			a1 = new AC("리소스");
			a1.abc();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (a1.s != null) {
				try {
					a1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		// 2. try with 구문 사용
		try (AC a2 = new AC("예외처리");) {
			a2.abc();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("예외처리");
		}
	}

}

class AC implements AutoCloseable {
	
	String s;
	
	AC() {}
	AC(String s) {
		this.s = s;
	}
	
	void abc() throws Exception {
		
	}
	
	@Override
	public void close() throws Exception {
		if (this.s != null) {
			s = null;
			System.out.println("리소스 해제");
		}
	}
	
}

class EA {
	public void input() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터를 입력하세요. : ");
//		String str = sc.nextLine();
//		System.out.println(str);
		int a = sc.nextInt();
		System.out.println(a);
	}
}
