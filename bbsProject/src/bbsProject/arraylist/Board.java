package bbsProject.arraylist;

public enum Board {
	BASIC("일반 게시판", "Basic Board"
			, new String[] {"NO", "제목", "글내용", "작성자", "이메일", "작성일"}
			, new BasicBoard(30)),
	EVENT("이벤트 게시판", "Event Board"
			, new String[] {"NO", "제목", "글내용", "작성자", "이메일", "작성일", "이벤트 날짜"}
			, new BasicBoard(30)),
	NOTICE("공지사항 게시판", "Notice Board"
			, new String[] {"NO", "제목", "글내용", "작성자", "이메일", "작성일", "첨부파일명"}
			, new BasicBoard(30));
	
	private final String nameKr;
	private final String nameUs;
	private final String[] fields;
	private final BoardInterface boardJob;
	
	private Board(String nameKr, String nameUs, String[] fields, BoardInterface boardJob) {
        this.nameKr = nameKr;
        this.nameUs = nameUs;
        this.fields = fields;
        this.boardJob = boardJob;
    }
	
	public String getNameKr() {
		return nameKr;
	}
	
	public String getNameUs() {
		return nameUs;
	}
	
	public String[] getFields() {
		return fields;
	}
	
	public BoardInterface getBoardJob() {
        return boardJob;
    }
}
