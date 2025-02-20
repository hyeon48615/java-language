package chap06_ex;

public class ExA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.print();
		
		// a 의 name에 값을 할당하고 출력한느 코드를 작성하세요.
		// a 의 a=10, b=20 값을 할당하고 출력하는 코드를 작성하세요.
		a.setName("홍길동");
		a.setA(10);
		a.setB(20);
		
		System.out.println("name: "+a.getName());
		System.out.println("a: "+a.getA()+", b: "+a.getB());
		
		// A 클래스에 사용자 정의 생성자를 추가하고 
		// 새로운 객체 생성시 초기화된 값을 출력하는 코드를 작성하세요.
		// 이름, 나이를 초기화 합니다.
		// name = "홍길순", age = 18
		// 출력 - 이름 : 홍길순, 나이 : 18
		A a1 = new A("홍길순", 18);
		
		// a, b 를 입력 받아
		// 더하기, 빼기, 곱하기, 나누기를 수행하는 함수를 작성하고
		// 내용을 출력하는 코드를 A 클래스에 추가하세요.
		// a=20, b=10;
		// fnPlus, fnMinus, fnCross, fnDiv
		int num1=20, num2=10;
		System.out.println("a+b="+a1.fnPlus(num1, num2));
		System.out.println("a-b="+a1.fnMinus(num1, num2));
		System.out.println("a*b="+a1.fnCross(num1, num2));
		System.out.println("a/b="+a1.fnDiv(num1, num2));
		
		// 클래스 A에 int[5][3] 변수 arrInt1 을 만들고 
		// 초기값을 Setter 를 이용하여 설정하고
		// Getter 를 이용하여 내용을 출력하는 코드를 추가하세요.
		int[][] arrayInt = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		a1.setArrInt(arrayInt);
		int[][] result = a1.getArrInt();
		for(int i=0; i<result.length; i++) {
			System.out.print("[");
			for(int j=0; j<result[i].length; j++) {
				System.out.printf(" %d ", result[i][j]);
			}
			System.out.println("]");
		}
	}

}
