package Level_2;

/*
 * 		@ 다음 큰 숫자
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12911
 *		@ 
 *		@ 
 */

public class PRG12911 {
	public int solution(int n) {
        int answer = n;
        int cnt = Integer.bitCount(n);
        
        while (true) {
        	answer++;
        	if (cnt == Integer.bitCount(answer))
        		break;
        }
        
        return answer;
    }
}
