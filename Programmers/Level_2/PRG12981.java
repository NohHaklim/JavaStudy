package Level_2;

import java.util.HashSet;
import java.util.Set;

/*
 * 		@ 영어 끝말잇기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12981
 *		@ 
 *		@ 
 */

public class PRG12981 {
	public int[] solution(int n, String[] words) {

		Set<String> s = new HashSet<String>();
		s.add(words[0]);
		for (int i = 1; i < words.length; i++) {
			int human = i % n;
			int th = i / n + 1;
			if (s.add(words[i]) == false
					|| words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
				return new int[] { human + 1, th };
			}
		}

		return new int[] { 0, 0 };
	}
}
