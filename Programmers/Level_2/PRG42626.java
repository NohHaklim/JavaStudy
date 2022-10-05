package Level_2;

import java.util.PriorityQueue;

/*
 * 		@ 더 맵게
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */

public class PRG42626 {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int e : scoville) {
        	pq.offer(e);
        }
        
        while (!pq.isEmpty() && pq.peek() < K) {
        	int a = pq.poll();
        	if (pq.isEmpty()) {
        		return -1;
        	}
        	int b = pq.poll();
        	pq.offer(a + b * 2);
        	answer++;
        }
        
        return answer;
    }
}
