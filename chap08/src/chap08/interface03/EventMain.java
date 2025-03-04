package chap08.interface03;

import java.util.Scanner;

public class EventMain {

	public static void main(String[] args) {
		EventImpl event = new EventImpl();
		CommonUtil utils = new CommonUtil();
		
//		String[][] arrList = event.getArrList();
		String[][] arrList = event.createDummy(100);
		
		int pageSize = 5;
		int pageNo = 4;
		int pageBlockSize = 5;
		
		event.setSearchCategory("TITLE");
		event.setSearchWord("2");
		event.searchList();
		
		event.setPageSize(pageSize);
		event.setPageNo(pageNo);
		event.setTotalCount(event.getArrList().length);
		event.setTotalPageNo();
		event.setPageSkipCount();
		event.setPageBlockSize(pageBlockSize);
		event.setPageBlockStart();
		event.setPageBlockEnd();
		
		event.bbsList(pageSize, pageNo, null, null);
		// event.printPagingArea();
		utils.printPagingArea(
			event.getTotalCount()
			, event.getPageSize()
			, event.getPageNo()
			, event.getPageBlockSize()
		);
		
		Scanner sc = new Scanner(System.in);
//		event.regist(new String[] {"사용자1", "1234", "사용자1@www.com", "제목1", "내용1", "2025-02-27", "2025-02-27"});
//		event.regist(event.create(sc));
//		event.bbsList(pageSize, pageNo, null, null);
//		event.printPagingArea();
		
//		int idx = event.searchIdx(sc);
//		if( idx != -1 ) {
//			event.view(idx);
//			event.delete(idx);
//			event.modify(idx, event.create(sc));
//		}
//		event.bbsList(pageSize, pageNo, null, null);
	} 

}