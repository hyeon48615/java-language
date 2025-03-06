package chap13.generic;

public class GenericMethodMain {

	public static void main(String[] args) {
		GenericMethod gm = new GenericMethod();
		
		String str1 = gm.<String>method1("HI");
		String str2 = gm.method1("HI2");
		
		System.out.println("str1: " + str1 + ", str2: " + str2);
		
		boolean b1 = gm.<Double>method2(2.5, 2.5);
		boolean b2 = gm.method2(2.5, 2.5);
		System.out.println("b1: " + b1 + ", b2: " + b2);
		
		gm.<String, Integer>method3("국어", 80);
		gm.method3("국어", 80);
	}

}

class GenericMethod {
	public <T> T method1(T t) {
		return t;
	}
	
	public <T> boolean method2(T t1, T t2) {
		return t1.equals(t2);
	}
	
	public <K,V> void method3(K k1, V v1) {
		System.out.println(k1 + " : " + v1);
	}
}