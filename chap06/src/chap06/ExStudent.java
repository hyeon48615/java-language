package chap06;

import chap006.Student2;

public class ExStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student std = new Student();
//		int[] arrInt = new int[3];
//		String arrStr = new String();
		System.out.println("std: "+ std.getAge());
		System.out.println("std: "+ std.getName());
		
		Student std2 = new Student("홍길동", 20);
		System.out.println("std2: "+ std2.getAge());
		System.out.println("std2: "+ std2.getName());
		
		Student2 std3 = new Student2();
		// chap006.Student2 std3 = new chap006.Student2();
		
		int grade = std.getUserGrade(6);
		System.out.println(grade + "학년 입니다.");
		
		std.goToSchool(); // 클래스 외부에서 호출시에 변수명. 으로 접근
		
		std.method1("H", "e", "l", "l", "o");
	}

}