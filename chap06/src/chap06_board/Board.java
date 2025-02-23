package chap06_board;

public enum Board {
	BASIC("게시판"),
	EVENT("이벤트 게시판"),
	NOTICE("공지사항 게시판");
	
	private final String name;
	
	private Board(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
