package chap08_board;

public interface BoardInterface {
	public abstract void regist(Object obj);
	public abstract void update(String no, Object obj);
	public abstract void delete(Menu menu, String no);
	public abstract Object[] select(Menu menu);
}
