package chap06_board;

public class test {

	public static void main(String[] args) {
		BoardJob a = new BoardJob();
		a.createDummy();
		
		PostBasic[] sotredList = new PostBasic[100];
		PostBasic[] tempList = new PostBasic[100];
		System.arraycopy(a.postList , 0, tempList, 0, a.postList.length);
		
		
		for(int i=0; i<tempList.length-1; i++) {
			PostBasic post = tempList[i];
			if(post instanceof PostBasic) {
				System.out.println(post.getValueOfField("title"));
			}
		}
		
	}

}

class A {
	public int a=1;
	public int b=2;
	public String str="test";
	
	public void getValueOfField(String field) {
		try {
			System.out.println(this.getClass().getDeclaredField(field).get(this));
		} catch(Exception e) {}
	}
}