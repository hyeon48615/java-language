package chap06_ex;

public class ExAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. Animal 을 상속받은
		// Dog
		// Cat
		// Bird
		// 클래스를 생성하세요.
		
		// 2. 아래와 같이 override 하고 실행하는 코드를 작성하세요.
		// Dog - 멍멍
		// Cat - 야옹
		// Bird - 짹짹
		Animal animal = new Animal();
		Dog dog = new Dog();
		Cat cat = new Cat();
		Bird bird = new Bird();
		
		animal.cry();
		dog.cry();
		cat.cry();
		bird.cry();
		
		// 3. 자식 클래스에 메서드를 추가하고, 실행하는 코드를 작성하세요.
		// Dog : rolling - 구르다 출력
		// Cat : ride - 오르다 출력
		// Bird : fly - 날다 출력
		dog.rolling();
		cat.ride();
		bird.fly();
		
		// 4. 각각의 자식 클래스에서 부모클래스 animal 의 메서드 cry()를
		// 출력하는 코드를 작성하세요.
		
		// 5. animal 클래스에 사용자 정의 생성자
		// species 의 값을 초기화하는 생성자를 추가
		// species 의 값을 Getter를 이용하여 조회하고,
		// species 의 값을 출력하는 printSpecies 함수를 추가하세요.
		Animal animal2 = new Animal("종");
		
		// 6. animal  클래스의 기본 생성자에서 
		// species 값을 "고래" 로 설정하는 코드를 추가하세요.
		
		// 7. 각각의 자식 클래스의 기본 생성자를 작성하고
		// 각각 부모의 기본생성자를 호출하는 코드를 추가하세요.
		
		// 8. 자식 클래스에 사용자 정의 생성자 추가
		// 각각 "개", "고양이", "새"를 생성자 매개변수로 전달하여
		// 부모 클래스에 생성자로 전달하여 초기화하는 코드를 작성하세요.
		// 부모 클래스에 초기화된 종의 값을 출력하는 코드와
		// printSpecies 를 자식 클래스에 추가하세요.
		
		// 1: 사용자 생성자 추가 Dog("개")
		// 2: 생성자 내부에서 부모 클래스의 생성자 호출 - 사용자 정의 생성자
		// 3: 자식 클래스 -> 부모 클래스 접근 및 정보 출력;
		Dog dog2 = new Dog("개");
		Cat cat2 = new Cat("고양이");
		Bird bird2 = new Bird("새");
		
		dog2.printSpecies();
		cat2.printSpecies();
		bird2.printSpecies();
	}

}
