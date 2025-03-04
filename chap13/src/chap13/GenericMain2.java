package chap13;

import java.util.Arrays;

public class GenericMain2 {

	public static void main(String[] args) {
		MyClass<String> myclass1 = new MyClass<String>();
		myclass1.set("HI");
		System.out.println(myclass1.get());
		
		MyClass<Integer> myclass2 = new MyClass<Integer>();
		myclass2.set(1000);
		System.out.println(myclass2.get());
		
		MyClass<Student> myclass3 = new MyClass<Student>();
		myclass3.set(new Student());
		System.out.println(myclass3.get());
		
		KeyValue<String, Integer> kv1 = new KeyValue<>();
		kv1.setKey("사과");
		kv1.setValue(1000);
		String k1 = kv1.getKey();
		int v1 = kv1.getValue();
		System.out.println("k1: " + k1 + ", v1: " + v1);
		
		String[][] arrList = new String[2][];
		KeyValue<Integer, String[][]> kv2 = new KeyValue<>();
		kv2.setKey(1);
		kv2.setValue(new String[][] { { "1", "제목1", "내용1", "작성자1" }, { "2", "제목2", "내용2", "작성자2" } });
		int k2 = kv2.getKey();
		String[][] v2 = kv2.getValue();
		System.out.println("k2: " + k2 + ", v2: " + Arrays.deepToString(v2));
		
		Goods<Fruits> goods1 = new Goods<>();
		goods1.set(new Fruits("사과", 1000));
		System.out.println(goods1.get().toString());
		goods1.set(new Fruits("배", 2000));
		System.out.println(goods1.get().toString());
	}

}

class Student {}