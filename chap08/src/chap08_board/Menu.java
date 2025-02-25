package chap08_board;

public enum Menu {
	BASIC("게시판"),
	EVENT("이벤트 게시판"),
	NOTICE("공지사항 게시판");
	
	private final String name;
	
	private Menu(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
