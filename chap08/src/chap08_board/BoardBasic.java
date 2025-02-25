package chap08_board;

public class BoardBasic {
	public BoardBasic() {}
	public BoardBasic(String title, String name, String regDate) {
		this.no = autoIncrement++;
		this.title = title;
		this.name = name;
		this.regDate = regDate;
	}
	protected BoardBasic(int no, String title, String name, String regDate) {
		this.no = no;
		this.title = title;
		this.name = name;
		this.regDate = regDate;
	}
	
	public int no;
	public String title;
	public String name;
	public String regDate;
	
	private static int autoIncrement = 1;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return no + ", " + title + ", " + name + ", " + regDate;
	}
}
