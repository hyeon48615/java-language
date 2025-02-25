package chap08_board;

public class BoardNotice extends BoardBasic {
	public BoardNotice() {}
	public BoardNotice(String title, String name, String regDate, String noticeFile) {
		super(autoIncrement++, title, name, regDate);
		this.noticeFile = noticeFile;
	}
	
	public String noticeFile;
	
	public static int autoIncrement = 1;

	public String getnoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
	}
	
	@Override
	public String toString() {
		return no + ", " + title + ", " + name + ", " + regDate + ", " + noticeFile;
	}
}
