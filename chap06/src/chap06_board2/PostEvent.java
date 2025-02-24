package chap06_board2;

public class PostEvent extends PostBasic {
	public PostEvent() {}
	public PostEvent(String title, String name, String regDate, String eventDate) {
		super(++autoIncrement, title, name, regDate);
		this.eventDate = eventDate;
	}
	
	private String eventDate;

	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	private static int autoIncrement = 0;
}
