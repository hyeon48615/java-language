package bbsProject.arraylist;

public class MyFormatter {
	// 한글 포맷팅 -> 글꼴 D2Coding 에서만 작동
	public static int getByteLength(String str) {
		int length = 0;
		if (str != null) {
			try {
				length = str.getBytes("euc-kr").length;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return length;
	}

	public static String getFormatStr(String str, int size) {
		int strByte = getByteLength(str);

		// 경우1) str이 size 보다 크면 문자열 자른후 반환
		if (strByte > size) {
			int sum = 0, index = 0;
			for (int i = 0; i < str.length(); i++) {
				String ch = str.substring(i, i + 1);
				sum += getByteLength(ch);

				if (sum == size) {
					index = ++i;
					break;
				} else if (sum > size) {
					index = i;
					break;
				}
			}
			return str.substring(0, index);
		}
		// 경우2) str이 size 보다 작으면 공백을 채워 반환
		else {
			int d = size - (getByteLength(str) - str.length());
			return String.format("%-" + d + "s", str);
		}
	}
}
