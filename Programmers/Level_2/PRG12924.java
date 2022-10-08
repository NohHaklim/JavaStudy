package Level_2;

/*
 * 		@ 숫자의 표현
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12924
 */

public class PRG12924 {
	public int solution(int n) {
        
        int sum = 0, cnt = 0, j = 1;
        for (int i = 1; i <= n; i++) {
        	sum += i;
        	while (sum > n) {
        		sum -= j;
        		j++;
        	}
        	if (sum == n) {
        		cnt++;
        	} 
        }
        
        return cnt;
    }
}
