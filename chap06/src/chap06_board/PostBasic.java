package chap06_board;

public class PostBasic {
	public PostBasic() {}
	public PostBasic(int idx, String title, String name, String regDate) {
		this.idx = idx;
		this.title = title;
		this.name = name;
		this.regDate = regDate;
	}
	
	public int idx;
	public String title;
	public String name;
	public String regDate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
			Object value = this.getClass().getField(field).get(this);
			return (value != null) ? value.toString() : null;
 		} catch (NoSuchFieldException e) {
			 System.err.println(field + " 필드를 찾을 수 없습니다.");
	    } catch (IllegalAccessException e) {
	        System.err.println(field + " 필드에 접근할 수 없습니다.");
	    } catch (ClassCastException e) {
	        System.err.println(field + " 필드는 String 타입이 아닙니다.");
	    }
	    return null;
	}
}
