package chap06;

public class ExCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car();
		System.out.println("car1.color: " + car1.color);
		car1.go();
		
		Car car2 = new Car("검정색");
		System.out.println("car2.color: " + car2.color);
	}

}
