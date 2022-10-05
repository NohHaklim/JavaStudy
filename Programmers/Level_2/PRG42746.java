package Level_2;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 		@ 가장 큰 수
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42746
 *		@ 1의 자리 숫자가 가장 큰 순서로 정렬해야 할 듯함.
 */

public class PRG42746 {
	public String solution(int[] numbers) {
		
		String[] str = new String[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			str[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		
		if (str[0].equals("0")) {
			return "0";
		}
		
		StringBuilder sb = new StringBuilder();
		for (String s : str) {
			sb.append(s);
		}
		
		return sb.toString();
    }
}
