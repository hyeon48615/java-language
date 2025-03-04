package chap08.interface04;

public class defulatMain {

	public static void main(String[] args) {
		// #1. 객체 생성
		A a1 = new B();
		A a2 = new C();
		
		// #2. 메서드 호출
		a1.abc();
		a1.bcd();
		a2.abc();
		a2.bcd();
		
		// #3. 정적 메서드 호출
		A.abcs();
	}

}

interface A {
	
	// 기존 메서드
	void abc(); // public abstract 생략
	
	// 신규 메서드
	default void bcd() {
		System.out.println("A 인터페이스의 bcd() 추가");
	}
	
	static void abcs() {
		System.out.println("A 인터페이스의 정적 메서드 abcs()");
	}
}

interface D {
	void abcc();
}

interface D2 extends D {
	void dbcc();
}

class B implements A {
	public void abc() {
		System.out.println("3년전 생성한 B 클래스의 abc()");
		A.super.bcd(); // 자식클래스에서 부모 인터페이스의 디폴트 메서드 접근 방법
	}
}

class C implements A {
	public void abc() {
		System.out.println("C 클래스의 abc()");
	}
}

class E implements A, D {

	@Override
	public void abcc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abc() {
		// TODO Auto-generated method stub
		
	}
	
}
