package Level_2;

import java.util.ArrayList;

/*
 * 		@ 기능개발
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */

public class PRG42586 {
	public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int[] remain = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
        	remain[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
        }
        
        int preNum = remain[0];
        int cnt = 1;
        for (int i = 1; i < remain.length; i++) {
        	if (preNum >= remain[i]) {
        		remain[i] = preNum;
        		cnt++;
        	} else {
        		preNum = remain[i];
        		list.add(cnt);
        		cnt = 1;
        	}
        }
        if (cnt >= 1) {
        	list.add(cnt);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}
