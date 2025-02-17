package chap06;

public class Car {
	String color;
	float weight;
	
	public Car() {}
	
	public Car(String color) {
		this.color = color;
	}
	
	public void go() {
		System.out.println("앞으로 갑니다");
	}
}
