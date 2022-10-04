package Level_2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 		@ 프린터
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */

class Data {
	public int prior;
	public boolean target = false;
	
	public Data(int prior) {
		this.prior = prior;
	}
}

public class PRG42587 {
	public int solution(int[] priorities, int location) {
       
        Queue<Data> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
        	Data data = new Data(priorities[i]);
        	if (i == location) {
        		data.target = true;
        	}
        	q.offer(data);
        	pq.add(priorities[i]);
        }
        
        int cnt = 0;
        while (!q.isEmpty()) {
        	Data data = q.poll();
        	if (data.prior == pq.peek()) {
        		pq.poll();
        		cnt++;
        		if (data.target) {
        			break;
        		}
        	} else {
        		q.offer(data);
        	}
        }
        
        return cnt;
    }
}
