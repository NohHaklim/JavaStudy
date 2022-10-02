package part2.java.lang;

public class StringExam {

	public static void main(String[] args) {
		String str1 = "hello world";
		String str2 = str1.substring(5);
		System.out.println(str1);
		System.out.println(str2);
		
		String str3 = str1 + str2;
		System.out.println(str3);
		
//		문자열의 덧셈은 사실 아래와 같은 로직을 거친다.
		String str4 = new StringBuffer().append(str1).append(str2).toString();
		System.out.println(str4);

//		따라서 다음과 같은 로직은 엄청 비효율적!
		String str5 = "";
		for (int i = 0; i < 100; i++) {
			str5 = str5 + "*";
		}
		System.out.println(str5);
		
//		이렇게 하면 효율적!
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 100; i++) {
			sb.append("*");
		}
		String str6 = sb.toString();
		System.out.println(str6);
	}

}
