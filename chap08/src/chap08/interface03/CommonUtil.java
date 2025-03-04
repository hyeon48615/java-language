package chap08.interface03;

public class CommonUtil {
	public void printPagingArea(int totalCount, int pageSize, int pageNo, int pageBlockSize) {
		int totalPageNo = 1;
		int pageBlockStart = 1;
		int pageBlockEnd = 1;
		
		totalPageNo = (int)Math.ceil(totalCount/(float)pageSize);
		pageBlockStart = (int)Math.floor(pageNo/(float)pageBlockSize)*pageBlockSize+1;
		pageBlockEnd = pageBlockStart + pageBlockSize - 1;
		pageBlockEnd = Math.min(pageBlockEnd, totalPageNo);
		
		System.out.print("<< < ");
		for(int i=pageBlockStart; i<=pageBlockEnd; i++) { 
			if(i == pageNo) { System.out.printf("\u001B[36m%d \u001B[0m", i); }
			else { System.out.printf("%d ", i); }
		}
		System.out.println("> >>");
	}
}
