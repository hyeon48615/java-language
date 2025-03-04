package chap13;

public class Goods<T> {
	private T t;
	
	public T get() {
		return this.t;
	}
	
	public void set(T t) {
		this.t = t;
	}
}
