package chap06_ex;

public class Cat extends Animal {
	
	public Cat() {
		super();
	}
	
	public Cat(String species) {
		super(species);
	}
	
	@Override
	public void cry() {
		super.cry();
		System.out.println("야옹");
	}
	
	@Override
	public void printSpecies() {
		System.out.println("Cat(species) 부모 클래스: "+super.getSpeices());
	}

	public void ride() {
		System.out.println("오르다");
	}
}
