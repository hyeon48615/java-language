package chap14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

public class FileEx3 {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		
		File file = new File("D:\\JAVA10\\JAVA\\test.txt");
		if (!file.exists()) file.createNewFile();
		
		Writer writer = new FileWriter(file);
		
		while(true) {
			System.out.print("문자열을 입력하세요...: ");
			String str = br.readLine();
			if (str.equals("q")) break;
			System.out.println(str);
			System.out.println();
			
			writer.append(str+"\n");
			writer.flush();
		}
		
		Reader r2 = new FileReader(file);
		BufferedReader br2 = new BufferedReader(r2);
		String sLine = "";
		while((sLine = br2.readLine()) != null) {
			System.out.println(sLine);
		}
		
		br.close();
		if (writer != null) {
			writer.close();
		}
	}

}