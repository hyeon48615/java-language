package chap06_ex;

public class Bird extends Animal {
	
	public Bird() {
		super();
	}
	
	public Bird(String species) {
		super(species);
	}
	
	@Override
	public void cry() {
		super.cry();
		System.out.println("짹짹");
	}
	
	@Override
	public void printSpecies() {
		System.out.println("Bird(species) 부모 클래스: "+super.getSpeices());
	}

	public void fly() {
		System.out.println("날다");
	}
}
