package Level_1;

import java.util.HashSet;
import java.util.Set;

/*
 * 		@ 로또의 최고 순위가 최저 순위
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/77484
 *		@ 
 *		@ 
 *		@ 
 */

public class PRG77484 {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int deleted = 0, match = 0;
        Set<Integer> s = new HashSet<>();
        for (int nb : lottos) {
        	if (nb == 0)
        		deleted++;
        	else
        		s.add(nb);
        }
        
        for (int nb : win_nums) {
        	if (!s.add(nb))
        		match++;
        }
        
        answer[1] = (match < 2) ? (6) : (7 - match);
        match += deleted;
        answer[0] = (match < 2) ? (6) : (7 - match);
        
        return answer;
    }
}
