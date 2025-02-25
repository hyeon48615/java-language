package chap08_board;

public class ExBoardInterface {

	public static void main(String[] args) {
		BoardJob boardJob = new BoardJob();
		
		boardJob.createDummy();
		
		Object[] boardList = boardJob.select(Menu.BASIC);
		Object[] eventList = boardJob.select(Menu.EVENT);
		Object[] noticeList = boardJob.select(Menu.NOTICE);
		
		System.out.println("[ BoardBasic ]");
		for(Object obj : boardList) {
			BoardBasic board = (BoardBasic)obj;
			System.out.println(board.toString());
		}
		
		boardJob.delete(Menu.BASIC, "2");
		
		boardList = boardJob.select(Menu.BASIC);
		System.out.println("[ BoardBasic ]");
		for(Object obj : boardList) {
			BoardBasic board = (BoardBasic)obj;
			System.out.println(board.toString());
		}
		
//		System.out.println("[ BoardEvent ]");
//		for(Object obj : eventList) {
//			BoardEvent board = (BoardEvent)obj;
//			System.out.println(board.toString());
//		}
//		
//		System.out.println("[ BoardNotice ]");
//		for(Object obj : noticeList) {
//			BoardNotice board = (BoardNotice)obj;
//			System.out.println(board.toString());
//		}
	}

}
