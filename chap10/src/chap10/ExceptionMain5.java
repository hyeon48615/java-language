package chap10;

public class ExceptionMain5 {

	public static void main(String[] args) {
		AE1 a = new AE1();
	}

}

// #1. Exception 상속하는 클래스 생성
// #2-1. Exception 상속
// #2-2. RuntimeException 상속
// #3. 예외 발생, 처리

class MyException1 extends Exception {
	MyException1() {}
	MyException1(String s) {
		super(s); // 부모 생성자 호출
	}
}

class MyException2 extends RuntimeException {
	MyException2() {}
	MyException2(String s) {
		super(s); // 부모 생성자 호출
	}
}

class AE1 {
	// 1. 사용자 정의 예외클래스 객체 생성
	MyException1 me1 = new MyException1();
	MyException1 me2 = new MyException1("예외 메시지");
	
	MyException2 re1 = new MyException2();
	MyException2 re2 = new MyException2("예외 메시지");
	
	// 3. 예외 발생
	
	// #1. try~catch
	void abc() {}
	void abc2() {}
	
	// #2. 예외 전가
	void abc3() {}
	void abc4() {}
}