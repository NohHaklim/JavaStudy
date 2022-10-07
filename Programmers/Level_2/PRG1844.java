package Level_2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 		@ 게임 맵 최단거리
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/1844
 *		@ 
 */

public class PRG1844 {
	
	static int[] dc = {0, 1, 0, -1};
	static int[] dr = {-1, 0, 1, 0};
	static int r, c;
	static boolean[][] visited;
	
	
	public int solution(int[][] maps) {
        
        r = maps.length;
        c = maps[0].length;
        visited = new boolean[r][c];
        
        return BFS(maps, 0, 0);
    }
	
	public int BFS(int[][] maps, int cr, int cc) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(cr, cc, 1));
		visited[cr][cc] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.r == r - 1 && p.c == c - 1)
				return p.cnt;
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = p.r + dr[dir];
				int nc = p.c + dc[dir];
				if (!inMap(nr, nc) || maps[nr][nc] == 0 || visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				q.offer(new Point(nr, nc, p.cnt + 1));
			}
		}
		return -1;
	}
	
	public boolean inMap(int nr, int nc) {
		if ((0 <= nr && nr < r)
				&& (0 <= nc && nc < c))
			return true;
		return false;
	}
}

class Point {
	int r, c, cnt;
	
	public Point(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}