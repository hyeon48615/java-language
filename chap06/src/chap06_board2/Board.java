package chap06_board2;

public enum Board {
	BASIC("게시판", new String[] { "제목", "이름", "등록일" }),
	EVENT("이벤트 게시판", new String[] { "제목", "이름", "등록일", "이벤트날짜" }),
	NOTICE("공지사항 게시판", new String[] { "제목", "이름", "등록일", "첨부파일명" });
	
	private final String name;
	private final String[] column;
	
	private Board(String name, String[] column) {
		this.name = name;
		this.column = column;
	}
	
	public String getName() {
		return name;
	}
	
	public String[] getColumn() {
		return column;
	}
}
