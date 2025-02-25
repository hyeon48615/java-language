package chap06_board;

public class test {

	public static void main(String[] args) {
		System.out.printf("%-10\t %-20s\t %-20s \n", "제목", "이름", "등록");
		System.out.printf("%-10.10\t %-20.20s\t %-20.20s \n", "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd", "이름", "등록");
		System.out.printf("%-10.10\t %-20.20s\t %-20.20s \n", "제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목", "이름", "등록");
	}

}

class A {
	public int a=1;
	public int b=2;
	public String str="test";
	
	public void getValueOfField(String field) {
		try {
			System.out.println(this.getClass().getDeclaredField(field).get(this));
		} catch(Exception e) {}
	}
}