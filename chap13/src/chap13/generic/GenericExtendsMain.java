package chap13.generic;

public class GenericExtendsMain {

	public static void main(String[] args) {
		// #1 부모 제네릭 클래스
		Parent<String> p = new Parent<>();
		p.setT("부모제네릭클래스");
		System.out.println(p.getT());

		// #2 자식 제네릭 클래스
		Child1<String> c1 = new Child1<>();
		c1.setT("자식1 제네릭 클래스");
		
		// #3 자식 제네릭 클래스
		Child2<String, Integer> c2 = new Child2<>();
		c2.setT("자식 2 제네릭 클래스");
		c2.setV(100);
		System.out.println(c2.getT());
		System.out.println(c2.getV());
		
		// ------------------------------------------
		// #1 부모 클래스의 제네릭 메서드 사용
		
		Parent2 p2 = new Parent2();
		p2.<Integer>print(10);
		p2.print(10);
		
		// #2 자식 클래스의 제네릭 메서드 사용
		Child3 c3 = new Child3();
		c3.<Double>print(5.8);
		p2.print(5.8);
	}

}


class Parent<T> {
	T t;
	
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
}

class Child1<T> extends Parent<T> {
	
}

class Child2<T, V> extends Parent<T> {
	V v;
	
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
}

class Parent2 {
	public <T> void print(T t) {
		System.out.println(t);
	}
}

class Child3 extends Parent2 {
	
}