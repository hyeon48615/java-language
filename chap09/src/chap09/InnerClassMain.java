package chap09;

public class InnerClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		A.B b = a.new B();
		b.bcd();
	}

}

class A {
	public int a = 3;
	protected int b = 4;
	int c = 5;
	private int  d = 6;
	
	void abc() {
		System.out.println("A 클래스 메서드");
	}
	
	class B {
		int a = 5;
		int b = 6;
		
		void bcd() {
			// #1. outer class 필드
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d); // A 클래스의 이너 클래스 이므로, private 필드에 접근 가능
			
			// #2. outer class 메서드
			abc();
			
			// #3. this 키워드
			System.out.println("class B: " + a); // 실행 시, this 키워드 자동 삽입
			System.out.println("class B: " + b);
			System.out.println("class B: " + this.a);
			System.out.println("class B: " + this.b);
			
			// #4. outer class 필드 접근
			System.out.println("class A: " + A.this.a);
			System.out.println("class A: " + A.this.b);
		}
	}
}

