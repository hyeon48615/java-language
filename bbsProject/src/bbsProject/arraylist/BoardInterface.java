package bbsProject.arraylist;

import java.util.List;

public interface BoardInterface {
	public abstract void regist(List<String> arrInput);
	public abstract void modify(String no, List<String> arrInput);
	public abstract void delete(String no);
	
	public abstract List<List<String>> retrieve();
	public abstract List<String> retrieveDetail(String no);
	public abstract List<List<String>> search(String category, String keyword);
	
	public abstract void printPageArea();
	public abstract void setPageNation(int pageNo, int pageSize, int pageBlockSize, int totalCount);
    public abstract void moveToFirstPage();
    public abstract void moveToLastPage();
    public abstract void moveLeft();
    public abstract void moveRight();
    public abstract void moveToPage(int pageNo);
}
