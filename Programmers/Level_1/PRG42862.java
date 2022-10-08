package Level_1;

import java.util.Arrays;

/*
 * 		@ 체육복
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */

public class PRG42862 {
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] have = new int[n + 2];
        Arrays.fill(have, 1, n + 1, 1);
        for (int i = 0; i < lost.length; i++)
        	have[lost[i]]--;
        for (int i = 0; i < reserve.length; i++)
        	have[reserve[i]]++;
        
        for (int i = 1; i <= n; i++) {
        	if (have[i] == 0) {
        		if (have[i - 1] == 2) {
        			have[i]++;
        			have[i - 1]--;
        		} else if (have[i + 1] == 2) {
        			have[i]++;
        			have[i + 1]--;
        		}
        	}
        }
        
        for (int i = 1; i <= n; i++) {
        	if (have[i] != 0)
        		answer++;
        }
        
        return answer;
    }
}
