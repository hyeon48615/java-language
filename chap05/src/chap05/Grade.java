package chap05;

public enum Grade {
	FIRST("1학년", 1),
	SECOND("2학년", 2),
	THIRD("3학년", 3),
	FOURTH("4학년", 4),
	FIFTH("5학년", 5),
	SIXTH("6학년", 6);
	
	private final String name;
	private final int value;
	
	private Grade(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public int getValue() {
		return this.value;
	}
}
