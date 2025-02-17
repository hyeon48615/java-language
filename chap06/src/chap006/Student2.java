package chap006;

public class Student2 {
	String name;
	int age;
	int ban;
	int grade;
	
	// 기본 생성자 -> 컴파일러가 자동으로 생성
	public Student2() {}
	
	// 사용자 정의 생성자
	// 사용자 정의 생성자 구현 시, 기본 생성자 반드시 생성
	public Student2(String name, int age) {
		this.name = name;
		this.age = age;
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
