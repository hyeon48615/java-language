package chap06_board;

public class PostEvent extends PostBasic {
	public PostEvent() {}
	public PostEvent(int idx, String title, String name, String regDate, String eventDate) {
		super(idx, title, name, regDate);
		this.eventDate = eventDate;
	}
	
	public String eventDate;

	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
}
