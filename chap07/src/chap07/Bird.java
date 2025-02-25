package chap07;

public class Bird extends Animal {
	@Override
	public void cry() {
		System.out.println("짹짹");
	}
	
	@Override
	public void eat() {
		System.out.println("모이를 먹습니다.");
	}
	
	public void fly() {
		System.out.println("새는 날 수 있습니다.");
	}
}
