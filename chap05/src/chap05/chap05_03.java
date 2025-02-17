package chap05;

import java.util.Calendar;

import chap05.Week;
import chap05.Grade;

public class chap05_03 {
	enum G { FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH };
	
	public static int G1 = 1;
	public static int G2 = 2;
	public static int G3 = 3;
	public static int G4 = 4;
	public static int G5 = 5;
	public static int G6 = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Week today = null;

		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		//System.out.println(week); // 일:1 ~ 토: 7
		
		switch(week) {
			case 1: today = Week.SATURDAY; break;
			case 2: today = Week.MONDAY; break;
			case 3: today = Week.TUESDAY; break;
			case 4: today = Week.WEDNESDAY; break;
			case 5: today = Week.THURSDAY; break;
			case 6: today = Week.FRIDAY; break;
			case 7: today = Week.SATURDAY; break;
		}
		
		System.out.println("오늘 : "+ today); // 일:1 ~ 토: 7
	
	
		for(Grade grade : Grade.values()) {
			System.out.println(grade.getName());
		}

		int grade = 5;
		
		if ( Grade.FIFTH.getValue() == grade ) {
			//5학년 업무 처리
		}
	}

}
enum E2 {
	FIRST,
	SECOND,
	THIRD,
	FOURTH,
	FIFTH,
	SIXTH
}
enum E {
	FIRST("1학년", 1),
	SECOND("2학년", 2),
	THIRD("3학년", 3),
	FOURTH("4학년", 4),
	FIFTH("5학년", 5),
	SIXTH("6학년", 6);
	
	private final String name;
	private final int value;
	
	private E(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public int getValue() {
		return this.value;
	}
}