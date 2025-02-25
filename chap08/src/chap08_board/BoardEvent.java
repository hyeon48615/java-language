package chap08_board;

public class BoardEvent extends BoardBasic {
	public BoardEvent() {}
	public BoardEvent(String title, String name, String regDate, String eventDate) {
		super(autoIncrement++, title, name, regDate);
		this.eventDate = eventDate;
	}
	
	public String eventDate;
	
	private static int autoIncrement = 1;

	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	@Override
	public String toString() {
		return no + ", " + title + ", " + name + ", " + regDate + ", " + eventDate;
	}
}
