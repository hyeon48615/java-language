package chap07;

public class ExAnimal {
	
	public static void main(String[] args) {
		// Animal animal = new Animal(); --> 추상 클래스는 직접 new 로 객체를 생성할 수 없다.
		Bird bird = new Bird(); // 반드시 상속 받은 후 구현
		
		Animal bird2 = new Bird(); // 상속, 객체생성, 암묵적인 형변환, casting, instanceof
		Animal dog2 = new Dog();
		
		// bird2 = dog2; // --> Animal
		
		Bird bird3 = new Bird();
		if (bird2 instanceof Bird) {
			bird3 = (Bird) bird2;
			bird3.fly();
		}
		
		Animal animal = null;
		
		animal = new Dog();
		animal.cry();
		animal.eat();
		
		animal = new Bird();
		animal.cry();
		animal.eat();
		
		animalCry(new Dog());
		animalCry(new Bird());
	}
	
	public static void animalCry(Animal animal) {
		animal.cry();
	}
}
