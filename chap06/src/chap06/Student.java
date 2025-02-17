package chap06;

public class Student {
	String name;
	int age;
	int ban;
	int grade;
	
	// 기본 생성자 -> 컴파일러가 자동으로 생성
	public Student() {}
	
	// 사용자 정의 생성자
	// 사용자 정의 생성자 구현 시, 기본 생성자 반드시 생성
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 리턴 값이 있는 메소드
	public int getUserGrade(int age) {
		// goToSchool(); => Student 자기 자신 내부에 선언된 메서드 호출
		int grade = 0;
		if (age < 8) {
			grade = 0;
		}
		else if (age == 8) {
			grade = 1;
		}
		else if (age == 9) {
			grade = 2;
		}
		else if (age == 10) {
			grade = 3;
		}
		else if (age == 11) {
			grade = 4;
		}
		else if (age == 12) {
			grade = 5;
		}
		else if (age == 13) {
			grade = 6;
		} else {
			grade = 7;
		}
		return grade;
	}
	
	// 리턴 값이 없는 메소드
	public void goToSchool() {
		int i = 0;
		while(true) {
			if (i > 10) {
				return; // 프로그램을 종료
				// System.exit(0); => 자바를 종료하는 내장함수
			}
			System.out.println("학교에 갑니다.");
			i++;
		}
	}
	
	// 함수 오버로딩 (중복 정의)
	public String goToSchool(String name) {
		return name + "이 학교에 갑니다.";
	}
	
	// 가변 길이 매개 변수
	public void method1 (String...str) {
		System.out.println("가변 길이 매개 변수 String : ");
//		for (int i=0; i < str.length; i++) { // str.length => 문자열의 개수
//			System.out.println(str[i]);
//		}
		
		for (String s : str) {
			System.out.print(s);
		}
	}
	
	public void method1 (int...ino) {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
