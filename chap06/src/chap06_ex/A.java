package chap06_ex;

import java.util.Arrays;

public class A {
	public A () {}
	public A (String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("이름 : "+this.name+", 나이 : "+this.age);
	}
	
	public String name;
	public int age;
	public int a;
	public int b;
	public int[][] arrInt1 = new int[5][3];
	
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
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public int[][] getArrInt() {
		return arrInt1;
	}
	public void setArrInt(int[][] arrInt1) {
		// this.arrInt1 = arrInt1;
		System.arraycopy(arrInt1, 0, this.arrInt1, 0, arrInt1.length);
	}
	public void print() {
		System.out.println("메시지를 출력합니다.");
	}
	
	public int fnPlus(int a, int b) {
		return a+b;
	}
	public int fnMinus(int a, int b) {
		return a-b;
	}
	public int fnCross(int a, int b) {
		return a*b;
	}
	public int fnDiv(int a, int b) {
		return a/b;
	}
}
