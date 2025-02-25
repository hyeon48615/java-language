package chap07;

public class Tax extends Car {
	
	public Tax() {
		super();
	}
	public Tax(String maker) {
		super(maker);
	}

	@Override
	public void ride() {
		System.out.println("승객을 태웁니다");
	}
	
	@Override
	public void fuel() {
		System.out.println("휘발유를 넣습니다");
	}
	
	public void meter() {
		System.out.println("미터기를 켭니다");
	}

}
