package Level_1;

import java.util.*;

/*
 * 		@ 성격 유형 검사하기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */

public class PRG118666 {

	// RT
	// CF
	// JM
	// AN

	public String solution(String[] survey, int[] choices) {
		
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> hm = new HashMap<>();
		hm.put('R', 0);
		hm.put('T', 0);
		hm.put('C', 0);
		hm.put('F', 0);
		hm.put('J', 0);
		hm.put('M', 0);
		hm.put('A', 0);
		hm.put('N', 0);

		for (int i = 0; i < survey.length; i++) {
			int choice = choices[i];
			if (choice < 4) {
				char what = survey[i].charAt(0);
				hm.put(what, hm.get(what) + (4 - choice));
			} else if (choice > 4) {
				char what = survey[i].charAt(1);
				hm.put(what, hm.get(what) + choice - 4);
			}
		}
		
		if (hm.get('R') >= hm.get('T'))
			sb.append('R');
		else
			sb.append('T');
		
		if (hm.get('C') >= hm.get('F'))
			sb.append('C');
		else
			sb.append('F');
		
		if (hm.get('J') >= hm.get('M'))
			sb.append('J');
		else
			sb.append('M');
		
		if (hm.get('A') >= hm.get('N'))
			sb.append('A');
		else
			sb.append('N');
			

		return sb.toString();
	}
}
