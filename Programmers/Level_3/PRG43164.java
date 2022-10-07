package Level_3;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 		@ 여행경로
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/43164
 *		@
 */

public class PRG43164 {

	public Queue<String> pq = new PriorityQueue<>();
	public boolean[] used;
	
	public String[] solution(String[][] tickets) {
        
		used = new boolean[tickets.length];
		
		DFS(tickets, "ICN", 0, "ICN");
		
		return pq.peek().split(",");
    }
	
	public void DFS(String[][] tickets, String currentCity, int cnt, String path) {
//		항공권은 모두 사용해야 한다는 전제 때문에 가능한 base case
		if (cnt == tickets.length) {
			pq.add(path);
			return;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			if (used[i] || !currentCity.equals(tickets[i][0]))
				continue;
			used[i] = true;
			DFS(tickets, tickets[i][1], cnt + 1, path + "," + tickets[i][1]);
			used[i] = false;
		}
	}
}