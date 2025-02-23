package chap06_board;

public class PostNotice extends PostBasic {
	public PostNotice() {}
	public PostNotice(int idx, String title, String name, String regDate, String noticeFile) {
		super(idx, title, name, regDate); 
		this.noticeFile = noticeFile;
	}
	
	public String noticeFile;

	public String getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
	}
}
