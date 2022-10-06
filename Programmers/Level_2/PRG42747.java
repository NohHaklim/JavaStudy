package Level_2;

import java.util.Arrays;

/*
 * 		@ H-Index
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */

public class PRG42747 {
	public int solution(int[] citations) {
        int answer = 0;
		
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
        	int h = citations.length - i;
        	
        	if (citations[i] >= h) {
        		answer = h;
        		break;
        	}
        }
        
        return answer;
    }
}
