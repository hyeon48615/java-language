package chap06_ex;

public class ExAnimal2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 다형성
		Animal animal = new Animal("종");
		
		// 1. dog --> cry() 동작성 확인
		// 2. dog --> Dog 다운캐스팅
		// 3. dog --> cry() 동작성 확인
		// 4. dog --> rolling() 동작성 확인
		
		// 경우1. 자식 자료형을 부모 자료형에 할당 시
		Animal dog = new Dog("개");
		
		dog.cry(); // 부모와 자식에게 모두 있는 메서드 -> 자식 메서드에 접근
		
		dog = (Dog)dog;
		dog.cry();
		// dog.rolling(); => Error. 자식 고유의 메서드 접근 불가
		
		System.out.println("===============");
		
		// 4. dog1 --> cry() 동작성 확인
		// 5. dog1 --> animal 업캐스팅
		// 6. dog1 --> cry() 동작성 확인
		// 7. dog1 --> rolling() 동작성 확인
		Dog dog1 = new Dog("푸들");
		
		dog1.cry();
		
		// dog1 = (Animal)dog1; => Error. Animal 은 Dog 가 아니다.
		if (dog1 instanceof Animal) {
			dog = (Animal)dog1;
		}
		
		dog.cry();
		dog1.rolling();
				
		// 8. Dog dog2 = dog; --> 에러를 수정하세요.
		Animal animal2 = new Dog("개");
		
		Dog dog2 = (Dog)animal2;
		dog2.cry();
		dog2.rolling();
		
		Animal animal3 = new Cat("고양이");
//		Dog dog3 = (Dog)animal3;
//		dog3.cry();
//		dog3.rolling();
		if (animal3 instanceof Dog) {
			Dog dog3 = (Dog)animal2;
			dog3.cry();
			dog3.rolling();
		}
		
	}

}
