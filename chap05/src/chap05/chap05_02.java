package chap05;

public class chap05_02 {

	public static void main(String[] args) {
		// 기본 자료형: 변수에 '값' 저장
		int a = 10;
		int b = a;
		System.out.println("a: "+a+", b: "+b);
		
		a = 20;
		System.out.println("a: "+a+", b: "+b);
		
		// 참조 자료형: 변수에 '메모리 주소' 저장
		int[] arrInt1 = {1,2,3};
		int[] arrInt2 = arrInt1;
		for(int i=0; i<arrInt1.length; i++) {
			System.out.println("arrInt1["+i+"]: "+arrInt1[i]);
		}
		for(int i=0; i<arrInt2.length; i++) {
			System.out.println("arrInt2["+i+"]: "+arrInt2[i]);
		}
		
		arrInt1[0] = 4;
		for(int i=0; i<arrInt1.length; i++) {
			System.out.println("arrInt1["+i+"]: "+arrInt1[i]);
		}
		for(int i=0; i<arrInt2.length; i++) {
			System.out.println("arrInt2["+i+"]: "+arrInt2[i]);
		}
		
		// '값'을 복사하고 싶을 때, arraycopy(원본, 시작위치, 복사대상, 시작위치, 개수);
		int[] arrInt3 = {1,2,3};
		int[] arrInt4 = new int[3];
		for(int i=0; i<arrInt3.length; i++) {
			System.out.println("arrInt3["+i+"]: "+arrInt3[i]);
		}
		for(int i=0; i<arrInt4.length; i++) {
			System.out.println("arrInt4["+i+"]: "+arrInt4[i]);
		}
		
		System.arraycopy(arrInt3, 0, arrInt4, 0, arrInt3.length);
		for(int i=0; i<arrInt3.length; i++) {
			System.out.println("arrInt3["+i+"]: "+arrInt3[i]);
		}
		for(int i=0; i<arrInt4.length; i++) {
			System.out.println("arrInt4["+i+"]: "+arrInt4[i]);
		}
		
		Books[] arrBooks1 = new Books[2];
		Books[] arrBooks2 = new Books[2];
		arrBooks1[0] = new Books("소년이 운다", 1000, 1.0F);
		arrBooks1[1] = new Books( "한강", 20000, 2.0F);
		System.arraycopy(arrBooks1, 0, arrBooks2, 0, arrBooks1.length);
		
		for(int i=0; i<arrBooks1.length; i++) {
			System.out.println("arrBooks1["+i+"]: "+arrBooks1[i].toString());
		}
		for(int i=0; i<arrBooks2.length; i++) {
			System.out.println("arrBooks2["+i+"]: "+arrBooks2[i].toString());
		}
		
		String[] arrStr = {"Java", "Android", "C", "C#", "C++"};
		for(String str : arrStr) {
			System.out.println("arrStr: " + str);
		}
	}
}

class Books {
	String name;
	int price;
	float f;
	
	public Books(String name, int price, float f) {
		this.name = name;
		this.price = price;
		this.f = f;
	}
	
	@Override
	public String toString() {
		return this.name + ", " + this.price + ", " + this.f;
	}
}
