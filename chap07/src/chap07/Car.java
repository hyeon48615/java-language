package chap07;

public abstract class Car {
	public String maker;
	
	public Car() {}
	public Car(String maker) {
		this.maker = maker;
	}
	
	public abstract void ride();
	public abstract void fuel();
	
	public void drive() {
		System.out.println("운전을 합니다");
	}
	
	public void stop() {
		System.out.println("정차합니다");
	}
}
