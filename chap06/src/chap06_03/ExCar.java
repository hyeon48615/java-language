package chap06_03;

public class ExCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Car car1 = new Car();
//		Car car2 = new Car("현대");
//		Car car3 = new Car("현대", "그랜져");

		Car car1 = new Car("현대", "그랜져", 4000);
		// car1.price;
		System.out.println("private price : " + car1.getPrice());
		car1.setPrice2(2000);
		System.out.println("private price : " + car1.getPrice());
		
		Suv suv1 = new Suv();
		suv1.setPrice2(2000);
		System.out.println("private price : " + suv1.getPrice());
	}

}
