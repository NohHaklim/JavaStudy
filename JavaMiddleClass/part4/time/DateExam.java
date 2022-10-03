package part4.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExam {

	public static void main(String[] args) {
		Date date = new Date();
		
//		System.out.println(date.toString());
		System.out.println(date);
		
//		'문자열' 문자열 출력 / zzz 기준시 / a 오전 오후 표시
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println(ft.format(date));
		System.out.println(date.getTime());		// 현재 시간을 long 타입으로 표현
		
		long today = System.currentTimeMillis();
		System.out.println(today);
		System.out.println(today - date.getTime());
	}

}
