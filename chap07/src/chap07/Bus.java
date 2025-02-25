package chap07;

public class Bus extends Car {
	
	public Bus() {
		super();
	}
	public Bus(String maker) {
		super(maker);
	}
	
	@Override
	public void ride() {
		System.out.println("승객을 태웁니다");
	}
	
	@Override
	public void fuel() {
		System.out.println("경유를 넣습니다");
	}
	
	public void bell() {
		System.out.println("");
	}
}
