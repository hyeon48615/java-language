package lambda;

public class LambdaEx1 {

	public static void main(String[] args) {
		// #1
		// 익명 이너클래스
		A a1 = new A() {
			@Override
			public void method1() {
				System.out.println("입력X, 출력X 함수");
			}
		};
		
		// 람다식
		A a2 = () -> { System.out.println("입력X, 출력X 함수"); };
		A a3 = () -> System.out.println("입력X, 출력X 함수");
		
		a1.method1();
		a2.method1();
		a3.method1();
		
		// #2
		// 익명 이너클래스
		B b1 = new B() {
			@Override
			public void method2(int a) {
				System.out.println("입력O, 출력X 함수: " + a);
			}
		};
		
		// 람다식
		B b2 = (int a) -> { System.out.println("입력O, 출력X 함수: " + a); };
		B b3 = (a) -> { System.out.println("입력O, 출력X 함수: " + a); };
		B b4 = (a) -> System.out.println("입력O, 출력X 함수: " + a);
		B b5 = a -> { System.out.println("입력O, 출력X 함수: " + a); };
		B b6 = a -> System.out.println("입력O, 출력X 함수: " + a);
		
		b1.method2(1);
		b2.method2(2);
		b3.method2(3);
		b4.method2(4);
		b5.method2(5);
		b6.method2(6);
		
		// #3
		// 익명 이너클래스
		C c1 = new C() {
			public int method3() {
				return 4;
			}
		};
		
		// 람다식
		C c2 = () -> { return 4; };
		C c3 = () -> 4;
		
		System.out.println("입력X, 출력O 함수: " + c1.method3());
		System.out.println("입력X, 출력O 함수: " + c2.method3());
		System.out.println("입력X, 출력O 함수: " + c3.method3());
		
		// #4 입력O, 출력O
		// 익명 이너클래스
		D d1 = new D() {
			@Override
			public double method4(int a, double b) {
				return a+b;
			}
		};
		
		// 람다식
		D d2 = (int a, double b) -> { return a+b; };
		D d3 = (a, b) -> { return a+b; };
		D d4 = (a, b) -> a+b;
		
		System.out.println("입력O, 출력O 함수: " + d1.method4(1, 1.0));
		System.out.println("입력O, 출력O 함수: " + d2.method4(2, 2.0));
		System.out.println("입력O, 출력O 함수: " + d3.method4(3, 3.0));
		System.out.println("입력O, 출력O 함수: " + d4.method4(4, 4.0));
	}

}

interface A {	// 입력X, 출력X
	void method1();
}

interface B {	// 입력O, 출력X
	void method2(int a);
}

interface C {	// 입력X, 출력O
	int method3();
}

interface D {	// 입력O, 출력O
	double method4(int a, double b);
}