package chap13.generic;

public class GenericTypeMain {

	public static void main(String[] args) {
		D<B> d2 = new D<>();
		D<C> d3 = new D<>(); 
		// 제네릭에서는 범위가 작은 것만 넣을 수 있다. -> 타입변환과 반대
		// 제약이 걸린 자료형보다 큰 자료형은 사용할 수 없다.
		D d4 = new D(); // D<B> d4 = new D<B>();
		
		d2.set(new B());
		d3.set(new C());
		
		d4.set(new B());
		d4.set(new C());
	}

}

class A {}
class B extends A {		// B는 A이다(o)
//	public <T> void method0(T t) {
//		char c = t.charAt(0); // 오류. Object 에서 제공하는 메서드만 사용 가능
//	}
	
	public <T extends String> void method1(T t) {
		char c = t.charAt(0);
	}
} 	
class C extends B {}	// C는 B이다(o)
class D <T extends B> {
	private T t;
	public T get() {
		return t;
	}
	
	public void set(T t) {
		this.t = t;
	}
}