package chap14;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class WriterEx1 {

	public static void main(String[] args) throws IOException {
		Writer writer = new FileWriter("D:\\JAVA10\\JAVA\\test1.txt");
		
		char a = 'A';
		char b = 'B';
		char c = 'C';
		writer.write(a);
		writer.write(b);
		writer.write(c);
		
		char[] arr = { 'A', 'B', 'C', 'D' };
		writer.write(arr);
		
		writer.write("Hello, Java~");
		
		writer.flush();
		writer.close();
		
		Reader reader = new FileReader("D:\\\\JAVA10\\\\JAVA\\\\test1.txt");

//		while(true) {
//			int data = reader.read();
//			if (data == -1) break;
//			System.out.println((char)data);
//		}
		
		char[] cbuf = new char[100];
		while(true) {
			int data = reader.read(cbuf);
			if (data == -1) break;
			for(char ch : cbuf) {
				System.out.print(ch);
			}
			System.out.println();
		}
		reader.close();
	}
}
