package chap05;

public class chap05_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrInt = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		// for 문
		for(int i=0; i<arrInt.length; i++) {
			System.out.println("arrInt["+i+"]: "+arrInt[i]);
		}
		
		// while 문
		int i=0;
		while(i<arrInt.length) {
			System.out.println("arrInt["+i+"]: "+arrInt[i]);
			i++;
		}
		
		int[] arrInt2 = new int[5];
		float[] arrF1 = new float[5];
		for(int j=0; j<arrInt2.length; j++) {
			System.out.println("arrInt2[]: "+arrInt2[j]); // 기본값 0
		}
		for(int j=0; j<arrF1.length; j++) {
			System.out.println("arrF1[]: "+arrF1[j]); // 기본값 0.0
		}
		
		char[] arrChar1 = new char[26];
		char ch = 'A';
		// int j=0 -> for 문 실행되는 동안 한 번 실행
		// j++, ch++ -> 가능한 문법이지만, 유지보수가 어려워지므로 가급적 사용X
		for(int j=0; j<arrChar1.length; j++, ch++) {
			System.out.println("arrChar1[]: "+arrChar1[j]); // 기본값 null
			System.out.println("ch: "+ch);
		}
		
		Books[] arrBook = new Books[5];
		for(int j=0; j<arrBook.length; j++) {
			System.out.println("Books[]: "+arrBook[j]); // 기본값 null
		}
	}
}

//class Books {
//	String name;
//	int price;
//	float f;
//}
