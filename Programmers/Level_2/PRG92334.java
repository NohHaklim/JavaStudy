package Level_2;

/*
 * 		@ 신고 결과 받기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */

import java.util.ArrayList;
import java.util.HashMap;

class PRG92334 {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		HashMap<String, ArrayList<String>> aReportB = new HashMap<String, ArrayList<String>>(1000);
		HashMap<String, Integer> reportedNumOfA = new HashMap<String, Integer>(1000);
		for (String id : id_list) {
			aReportB.put(id, new ArrayList<String>(1000));
			reportedNumOfA.put(id, 0);
		}

		for (String content : report) {
			String[] aB = content.split(" ");
			if (aReportB.get(aB[0]).contains(aB[1]) == false) {
				aReportB.get(aB[0]).add(aB[1]);
				if (reportedNumOfA.get(aB[1]) == k) {
					continue;
				}
				reportedNumOfA.put(aB[1], reportedNumOfA.get(aB[1]).intValue() + 1);
			}
		}

		int i = 0;
		for (String id : id_list) {
			int cnt = 0;
			for (String reported : aReportB.get(id)) {
				if (reportedNumOfA.get(reported) == k) {
					cnt++;
				}
			}
			answer[i++] = cnt;
		}
		return answer;
	}
}
