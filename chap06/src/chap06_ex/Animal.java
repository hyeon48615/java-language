package chap06_ex;

public class Animal {	
	public Animal() {
		this.species = "동물";
		System.out.println("Animal: "+this.getSpeices());
	}
	public Animal(String species) {
		this.species = species;
	}
	
	String species;
	
	public String getSpeices() {
		return this.species;
	}
	
	public void cry() {
		System.out.println("울다");
	}
	public void run() {
		System.out.println("달리다");
	}
	public void printSpecies() {
		System.out.println("Animal: "+this.getSpeices());
	}
}
