package Level_3;

/*
 * 		@ 최고의 집합
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12938
 *		@ 1. s를 n으로 나눠서 얻은 값들을 배열에 저장.
 *		@ 2. 나머지만큼 배열에 + 1
 */

public class PRG12938 {
	public int[] solution(int n, int s) {
        
        if (n > s) {
        	return new int[] { -1 };
        }
        
        int[] answer = new int[n];
        
        int base = s / n;
        int mod = s % n;
        for (int i = n - 1; i >= 0; i--) {
        	answer[i] = base;
        	if (mod != 0) {
        		answer[i]++;
        		mod--;
        	}
        }
        
        return answer;
    }
}
