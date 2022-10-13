package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 		@ 보물섬
 *		@ https://www.acmicpc.net/problem/2589
 */

public class BOJ2589 {

	static int N, M;
	static char[][] Map;
	static boolean[][] Visited;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new char[N][M];
		Visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for (int j = 0; j < M; j++) {
				Map[i][j] = temp.charAt(j);
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (Map[i][j] == 'L') {
					answer = Math.max(answer, BFS(new Point(i, j, 0)));
					for (int k = 0; k < N; k++)
						Arrays.fill(Visited[k], false);
				}
			}
		}
		System.out.println(answer);
	}

	static int BFS(Point s) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(s);
		Visited[s.r][s.c] = true;

		int ret = 0;
		while (!q.isEmpty()) {
			Point f = q.poll();
			ret = Math.max(ret, f.cnt);
			for (int dir = 0; dir < 4; dir++) {
				int nr = f.r + dr[dir];
				int nc = f.c + dc[dir];
				
				if (!isValid(nr, nc) || Visited[nr][nc])
					continue;
				Visited[nr][nc] = true;
				q.offer(new Point(nr, nc, f.cnt + 1));
			}
		}
		return ret;
	}
	
	static boolean isValid(int r, int c) {
		if ((0 <= r && r < N) && (0 <= c && c < M) && (Map[r][c] == 'L'))
			return true;
		return false;
	}
}

class Point {
	int r, c, cnt;

	Point(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}