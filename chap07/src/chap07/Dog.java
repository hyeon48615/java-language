package chap07;

public class Dog extends Animal {
	@Override
	public void cry() {
		System.out.println("멍멍");
	}
	
	@Override
	public void eat() {
		System.out.println("사료를 먹습니다.");
	}
	
	public void run() {
		System.out.println("개는 달릴 수 있습니다.");
	}
}
