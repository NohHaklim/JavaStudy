package important;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 		@ 디스크 컨트롤러
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */

public class PRG42627 {
	public int solution(int[][] jobs) {
        int answer = 0;
        
//      시간을 우선적으로 보는 작업 목록
        PriorityQueue<Integer> pqTime = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(jobs[o1][0], jobs[o2][0]);
			}
        });
        
        for (int i = 0; i < jobs.length; i++) {
        	pqTime.offer(i);
        }
        
//      작업량을 우선적으로 보는 작업 목록
        PriorityQueue<Integer> pqWork = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(jobs[o1][1], jobs[o2][1]);
			}
		});
        
        int time = 0;
        while (!pqTime.isEmpty()) {
        	while (!pqTime.isEmpty() && jobs[pqTime.peek()][0] <= time) {
        		pqWork.offer(pqTime.poll());
        	}
        	if (pqWork.isEmpty()) {
        		time++;
        		continue;
        	}
        	int nextJob = pqWork.poll();
        	time += jobs[nextJob][1];
        	answer += time - jobs[nextJob][0];
        }
        
        while (!pqWork.isEmpty()) {
        	int nextJob = pqWork.poll();
        	time += jobs[nextJob][1];
        	answer += time - jobs[nextJob][0];
        }
        
        return answer / jobs.length;
    }
}
