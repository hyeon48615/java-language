package chap06_ex;

public class Dog extends Animal {
	
	public Dog() {
		super();
	}
	
	public Dog(String species) {
		super(species);
	}
	
	@Override
	public void cry() {
		super.cry();
		System.out.println("멍멍");
	}
	
	@Override
	public void printSpecies() {
		System.out.println("Dog(species) 부모 클래스: "+super.getSpeices());
	}
	
	public void rolling() {
		System.out.println("구르다");
	}
}
