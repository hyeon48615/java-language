//package chap13;
//
//public class GenericMain {
//
//	public static void main(String[] args) {
//		Goods1 goods1 = new Goods1();
//		goods1.set(new Apple());
//		goods1.get();
//		
//		Goods2 goods2 = new Goods2();
//		goods2.set(new Pencil());
//		goods2.get();
//		
//		// 문제) 상품이 추가될 때마다 클래스 생성
//		// 아이디어1) 프로퍼티, 메서드 -> Object 로 처리
//		// => castting 시에 오류 발생, RuntimeException 발생
//		
//		// 제네릭 타입(Generic Type)
//	}
//
//}
//
//class Apple {
//	
//}
//
//class Pencil {
//	
//}
//
//class Goods1 {
//	private Apple apple = new Apple();
//	public Apple get() {
//		return apple;
//	}
//	public void set(Apple apple) {
//		this.apple = apple;
//	}
//}
//
//class Goods2 {
//	private Pencil pencil = new Pencil();
//	public Pencil get() {
//		return pencil;
//	}
//	public void set(Pencil pencil) {
//		this.pencil = pencil;
//	}
//}