package chap06_board2;

public class PostNotice extends PostBasic {
	public PostNotice() {}
	public PostNotice(String title, String name, String regDate, String noticeFile) {
		super(++autoIncrement, title, name, regDate); 
		this.noticeFile = noticeFile;
	}
	
	private String noticeFile;
	
	private static int autoIncrement = 0;

	public String getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
	}
}
