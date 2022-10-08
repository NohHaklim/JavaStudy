package Level_2;

/*
 * 		@ 피보나치 수
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */

public class PRG12945 {
	public int solution(int n) {
        
        if (n == 0 || n == 1)
        	return n;
        
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
        	a = b;
        	b = c;
        	c = a + b;
        	if (c > 1234567)
        		c %= 1234567;
        }
        
        return c;
    }
}
