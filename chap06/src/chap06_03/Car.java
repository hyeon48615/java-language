package chap06_03;

public class Car {
	String maker;
	String name;
	int weight;
	int size;
	int wheel;
	private int price;
	
	public Car() {
		System.out.println("기본 생성자");
	} 
	
	public Car(String maker) {
		// System.out.println("사용자 정의 생성자1"); -> this() 메서드는 반드시 첫 줄에 사용
		this(); // 기본 생성자, Car() 생성자를 호출
		this.maker = maker;
		System.out.println("사용자 정의 생성자1 : maker = " + this.maker);
	}
	
	public Car(String maker, String name) {
		this(maker); // Car(String maker) 생성자를 호출
		this.name = name;
		System.out.println("사용자 정의 생성자2 : maker = " + this.maker + ", name = " + this.name);
	}
	 
	public Car(String maker, String name, int price) {
		this(maker); // Car(String maker) 생성자를 호출
		this.name = name;
		this.price = price;
		System.out.println("사용자 정의 생성자2 : maker = " + this.maker + ", name = " + this.name + ", price : "+price);
	}
	
	public int getPrice() {
		return this.price;
	}
	private void setPrice(int price) {
		this.price = price;
	}
	
	public void setPrice2(int price) {
		this.price = price;
	}
	
	
}
