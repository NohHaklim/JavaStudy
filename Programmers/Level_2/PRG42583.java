package Level_2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 		@ 다리를 지나는 트럭
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */

public class PRG42583 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0;
        int totW = 0;
        
		Queue<Integer> q = new LinkedList<>();
		
        for (int truck : truck_weights) {
        	while (true) {
        		if (q.isEmpty()) {
        			q.offer(truck);
        			totW += truck;
        			time++;
        			break;
        		} else if (q.size() == bridge_length) {
        			totW -= q.poll();
        		} else {
        			if (totW + truck <= weight) {
        				q.offer(truck);
        				totW += truck;
        				time++;
        				break;
        			} else {
        				q.offer(0);
        				time++;
        			}
        		}
        	}
        }
        
        return time + bridge_length;
    }
}
