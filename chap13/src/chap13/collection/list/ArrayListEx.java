package chap13.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		List studentList = new ArrayList();
		
		studentList.add(new Student("홍길동", 20, 1));
		studentList.add(new Student("홍길순", 21, 2));
		studentList.add(new Student("박문수", 22, 3));
		studentList.add(new Student("에스파", 23, 4));
		studentList.add(new Student("뉴진스", 23, 4));
		studentList.add(new Student("박찬호", 20, 1));
		studentList.add(new Student("이정후", 24, 4));
		
		int i = 1;
		for(Object std : studentList) {
			System.out.println(i + ". " + std.toString());
			i++;
		}
		
		for(int j=0; j<studentList.size(); j++) {
			System.out.println(j+1 + ". " + studentList.get(j).toString());
		}
	}

}

class Student {
	Student() {}
	Student(String name, int age, int grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	
	String name;
	int age;
	int grade;
	
	public String getName() {
		return name;
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return this.name + ", " + this.age + ", " + this.grade;
	}
}
