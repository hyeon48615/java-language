package chap13.generic;

public class GenericTypeBoundMain {

	public static void main(String[] args) {
		Test t = new Test();
		
		// #1
		t.method1(new Goods<AA>());
		// t.method1(new Goods<BB>());
		// t.method1(new Goods<CC>());
		// t.method1(new Goods<CC>());
		
		// #2
		t.method2(new Goods<AA>());
		t.method2(new Goods<BB>());
		t.method2(new Goods<CC>());
		t.method2(new Goods<CC>());
		
		// #3
		// t.method3(new Goods<AA>());
		t.method3(new Goods<BB>());
		t.method3(new Goods<CC>());
		t.method3(new Goods<CC>());
		
		// #4
		t.method4(new Goods<AA>());
		t.method4(new Goods<BB>());
		// t.method4(new Goods<CC>());
		// t.method4(new Goods<CC>());
	}

}

class AA {}
class BB extends AA {}
class CC extends BB {}
class DD extends CC {}

class Goods<T> {
	private T t;
	public T get() {
		return t;
	}
	public void set(T t) {
		this.t = t;
	}
}

class Test {
	void method1(Goods<AA> g) {}			// #1
	void method2(Goods<?> g) {}				// #2
	void method3(Goods<? extends BB> g) {}	// #3
	void method4(Goods<? super BB> g) {}	// #4
}