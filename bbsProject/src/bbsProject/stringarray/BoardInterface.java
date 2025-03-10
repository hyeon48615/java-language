package bbsProject.stringarray;

public interface BoardInterface {
	public abstract void regist(String[] arrInput);
	public abstract void modify(String no, String[] arrInput);
	public abstract void delete(String no);
	
	public abstract String[][] retrieve();
	public abstract String[] retrieveDetail(String no);
	public abstract String[][] search(String category, String keyword);
	
	public abstract void printPageArea();
	public abstract void setPageNation(int pageNo, int pageSize, int pageBlockSize, int totalCount);
    public abstract void moveToFirstPage();
    public abstract void moveToLastPage();
    public abstract void moveLeft();
    public abstract void moveRight();
    public abstract void moveToPage(int pageNo);
}
