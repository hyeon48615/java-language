package chap08.interface03;

public interface BasicBbsIf {
	public abstract void bbsList(int pageSize, int pageNo
				, String searchCategory, String searchKeyword);
	public abstract void regist(String[] arrInput);
	public abstract void view(int no);
	public abstract void modify(int no, String[] arrInput);
	public abstract void delete(int no);
}
