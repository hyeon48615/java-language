package chap10;

import java.io.InputStreamReader;
import java.util.Scanner;

public class ExceptionMain3 {
	
	public static void main(String[] args) {
		try {
			System.out.println(3/0);
		} catch(ArithmeticException e) {
			System.out.println("0 으로 나눌 수 없습니다.");
		} catch(Exception e) {
			
		} finally {
			System.out.println("최종적으로 처리되는 부분");
		}
		
		String strInput = "";
		try (
			Scanner sc = new Scanner(System.in);
			InputStreamReader isr = new InputStreamReader(System.in);
		) {
			System.out.println("내용을 입력하세요: ");
			strInput = sc.nextLine();
			System.out.println("입력 문자 : " + strInput);
		}
		catch (Exception e) {
			// e.printStackTrace();
		} finally {
			
		}
	}
}
