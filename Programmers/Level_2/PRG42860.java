package Level_2;

/*
 * 		@ 최솟값 만들기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */

public class PRG42860 {
	public int solution(String name) {
		
		int answer = 0;
		int len = name.length();
		// 오른쪽으로 완전 이동
		int min = len - 1;
		
		for (int i = 0; i < len; i++) {
			char ch = name.charAt(i);
			answer += (ch <= 'N') ? (ch - 'A') : ('Z' - ch + 1);
			
			// 좌우 이동
			// 연속된 'A'의 개수 카운팅
			int nextIdx = i + 1;
			while (nextIdx < len && name.charAt(nextIdx) == 'A')
				nextIdx++;
			
			// i * 2는 왼쪽으로 다시 가는 길이
			// len - nextIdx는 오른쪽에서 이동한 길이
			min = Math.min(min, (i * 2) + len - nextIdx);
			min = Math.min(min, (len - nextIdx) * 2 + i);
		}
		
		answer += min;
        
        return answer;
    }
}
