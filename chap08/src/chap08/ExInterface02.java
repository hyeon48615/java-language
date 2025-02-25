package chap08;

public class ExInterface02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface A {
	public static final int a = 10;
	public abstract void a();
}

interface B {
	public static final int b = 10;
	public abstract void b();
}

interface C {
	public static final int c = 10;
	public abstract void c();
}

class ExInterfaceA implements A {

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	}
	
}

class ExInterfaceAB implements A, B {

	@Override
	public void b() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	}
	
}

class ExInterfaceABC implements A, B, C {

	@Override
	public void c() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void b() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	}
	
}