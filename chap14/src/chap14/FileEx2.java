package chap14;

import java.io.File;

public class FileEx2 {

	public static void main(String[] args) {
		File tempDir = new File("D:\\JAVA10\\JAVA\\temp");
		if (!tempDir.exists()) tempDir.mkdir();
		
		File file1 = new File("D:\\JAVA10\\JAVA");
		System.out.println("절대경로: " + file1.getAbsolutePath());
		System.out.println("폴더여부: " + file1.isDirectory());
		System.out.println("파일여부: " + file1.isFile());
		System.out.println("파일이름: " + file1.getName());
		System.out.println("부모폴더이름: " + file1.getParent());
		
		File file2 = new File("D:\\JAVA10\\JAVA\\temp\\abc");
		System.out.println(file2.mkdir());

		File file3 = new File("D:\\JAVA10\\JAVA\\temp\\abc\\xxx");
		System.out.println(file3.mkdir());
		System.out.println(file3.mkdirs());
		
		File file4 = new File("D:\\JAVA10\\JAVA\\temp\\abc\\xxx\\yyy\\zzz");
		System.out.println(file4.mkdir());
		System.out.println(file4.mkdirs());
		
		File[] files = file1.listFiles();
		for(File f : files) {
			System.out.println((f.isDirectory() ? "폴더: " : "파일: ") + f.getName());
		}
	}

}
