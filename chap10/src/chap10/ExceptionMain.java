package chap10;

public class ExceptionMain {

	public static void main(String[] args) {
		// Thread.sleep(1000);
		// Class cls = Class.forName("Java.lang.Object");
		// InputStreamReader isr = new InputStreamReader(System.in);
		// isr.read();
		// FileInputStream fis = new FileInputStream("test.txt");
		
		// clone
		// A a1 = new A();
		// A a2 = (A)a1.clone();
	}

}

class A {
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}