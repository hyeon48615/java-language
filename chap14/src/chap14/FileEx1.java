package chap14;

import java.io.File;
import java.io.IOException;

public class FileEx1 {

	public static void main(String[] args) throws IOException {
		// 윈도우, 리눅스, 맥 호환을 위해 File separator 사용
		File file1 = new File("D:"+File.separator+"JAVA10"+File.separator+"JAVA"+File.separator+"file1.txt");
		if (!file1.exists()) {
			file1.createNewFile();
		}
	}

}
