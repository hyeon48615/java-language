package chap06_board2;

import java.lang.reflect.Field;

public class PostBasic {
	public PostBasic() {}
	
	// 함수 외부에서 생성할 때, autoIncrement 수행
	public PostBasic(String title, String name, String regDate) {
		this.idx = ++autoIncrement;
		this.title = title;
		this.name = name;
		this.regDate = regDate;
	}
	
	// 자식 클래스에서 생성할 때, autoIncrement 수행X
	protected PostBasic(int idx, String title, String name, String regDate) {
		this.idx = idx;
		this.title = title;
		this.name = name;
		this.regDate = regDate;
	}
	
	protected int idx;
	private String title;
	private String name;
	private String regDate;
	
	private static int autoIncrement = 0;
	
	public int getIdx() {
		return idx;
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

	public String getValueOfField(String field) {
		try {
			Field f = this.getClass().getField(field);
			f.setAccessible(true);
			Object value = f.get(this);
			return (value != null) ? value.toString() : null;
 		} catch (NoSuchFieldException e) {
			 System.err.println(field + " 필드를 찾을 수 없습니다.");
	    } catch (IllegalAccessException e) {
	        System.err.println(field + " 필드에 접근할 수 없습니다.");
	    } 
	    return null;
	}
}
