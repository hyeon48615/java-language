package chap09;

public class InnerMethodClassMain {

	public static void main(String[] args) {
		MA a = new MA();
		a.abc();
	}

}

class MA {
	int a = 3;
	void abc() {
		int b = 5; // final int b= 5; 자동으로 변경
		
		class B {
			void bcd() {
				System.out.println("A 클래스 필드 a : " + a); // MA.this.a : 아우터클래스 접근 가능
				System.out.println("abc() 내의 필드 b: " + b); // 지역변수 접근가능
				a = 7; // 아우터클래스 필드값 변경 가능
				// b = 10; // 지역변수값 변경 불가능 -> final 성격. 재할당 불가능
			}
		}
		
		B bb = new B();
		bb.bcd();
	}
	
	void abc2() {
		class B {}
		class C {}
		class D {}
	}
}