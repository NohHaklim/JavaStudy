package important;

import java.util.ArrayList;

/*
 * 		@ 모의고사
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */

public class PRG42840 {
	public int[] solution(int[] answers) {

		int[] stu1 = new int[] { 1, 2, 3, 4, 5 };
		int[] stu2 = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] stu3 = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		
		int sco1 = 0, sco2 = 0, sco3 = 0;
		
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == stu1[i % stu1.length]) {
				sco1++;
			}
			if (answers[i] == stu2[i % stu2.length]) {
				sco2++;
			}
			if (answers[i] == stu3[i % stu3.length]) {
				sco3++;
			}
		}
		
		int maxScore = Math.max(sco1, Math.max(sco2, sco3));
		ArrayList<Integer> list = new ArrayList<>();
		if (maxScore == sco1) list.add(1);
		if (maxScore == sco2) list.add(2);
		if (maxScore == sco3) list.add(3);
		
		return list.stream().mapToInt(i->i.intValue()).toArray();
	}
}
