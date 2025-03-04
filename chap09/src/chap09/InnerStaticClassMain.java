package chap09;

public class InnerStaticClassMain {

	public static void main(String[] args) {
		// IA a = new IA();
		// IA.b b = a.new B(); // 호출 불가
		
		IA.B b = new IA.B();
		b.bcd();
	}

}

class IA {
	public int a = 3;
	static int b = 4;
	
	void method1() {
		System.out.println("IA 클래스 instance 메서드");
	}
	
	static void method2() {
		System.out.println("IA 클래스 static 메서드");
	}
	
	static class B {
		void bcd() {
			// #1. outer class 필드
			// System.out.println(a);
			System.out.println(b); // static 필드
			
			// #2. outer class 메서드
			// method1();
			method2();
		}
	}
}

