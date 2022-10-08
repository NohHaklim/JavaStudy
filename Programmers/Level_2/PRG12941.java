package Level_2;

import java.util.Arrays;

/*
 * 		@ 최솟값 만들기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */

public class PRG12941 {
	public int solution(int []A, int []B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        for (int i = 0; i < len; i++) {
        	answer += A[i] * B[len - i - 1];
        }

        return answer;
    }
}
