package Level_1;

/*
 * 		@ 자릿수 더하기
 *		@ https://school.programmers.co.kr/learn/courses/18/lessons/1876
 *		@ 
 *		@ 
 */

public class PRG1876 {
	public int solution(int n) {
        int answer = 0;

        while (n != 0) {
        	answer += n % 10;
        	n /= 10;
        }

        return answer;
    }
}
