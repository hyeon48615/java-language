package chap07;

public class ExCar {

	public static void main(String[] args) {
		Car car = null;
		
		car = new Bus("현대");
		System.out.println(car.maker);
		car.drive();
		car.fuel();
		car.ride();
		car.stop();
		
		String bell = "";
		if(car instanceof Bus) {
			Bus bus = (Bus)car;
			bus.bell();
		}
		if (bell != "") {
			
		}
		
		car = new Tax("기아");
		System.out.println(car.maker);
		car.drive();
		car.fuel();
		car.ride();
		car.stop();
	}

}
