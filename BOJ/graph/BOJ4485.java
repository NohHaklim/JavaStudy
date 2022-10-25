package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 		@ 서강그라운드
 *		@ https://www.acmicpc.net/problem/14938
 *		@
 */

public class BOJ4485 {

	static int n, ret;
	static int[][] map;
	static int[][] dijk;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static boolean isValid(int r, int c) {
		if (0 <= r && r < n && 0 <= c && c < n)
			return true;
		return false;
	}
	
	static int dijk(Point p) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		dijk[0][0] = map[0][0];
		pq.offer(new Point(0, 0, map[0][0]));
		
		while (!pq.isEmpty()) {
			Point curr = pq.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr.r + dr[dir];
				int nc = curr.c + dc[dir];
				
				if (!isValid(nr, nc))
					continue;
				if (dijk[nr][nc] > dijk[curr.r][curr.c] + map[nr][nc]) {
					dijk[nr][nc] = dijk[curr.r][curr.c] + map[nr][nc];
					pq.offer(new Point(nr, nc, dijk[nr][nc]));
				}
			}
		}
		return dijk[n - 1][n - 1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nb = 0;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			dijk = new int[n][n];
			if (n == 0)
				break;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dijk[i][j] = Integer.MAX_VALUE;
				}
			}
			System.out.print(new StringBuilder("Problem ").append(nb + 1).append(": ").append(dijk(new Point(0, 0, map[0][0]))).append("\n").toString());
			nb++;
		}
	}
	
	static class Point implements Comparable<Point>{
		int r, c, cost;
		
		Point (int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
}