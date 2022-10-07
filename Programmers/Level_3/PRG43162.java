package Level_3;

/*
 * 		@ 네트워크
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/43162
 *		@ 
 */

public class PRG43162 {
	
	static boolean[] visited;
	
	public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[computers.length];
        
//      사실 이미 visited에 체크되기 때문에 없어도 되는 코드
        for (int i = 0; i < computers.length; i++) {
        	computers[i][i] = 0;
        }
        
        for (int i = 0; i < computers.length; i++) {
        	if (!visited[i]) {
        		DFS(computers, i);
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public void DFS(int[][] computers, int from) {
		visited[from] = true;
		
		for (int to = 0; to < computers.length; to++) {
			if (visited[to] || computers[from][to] == 0)
				continue;
			DFS(computers, to);
		}
	}
}
