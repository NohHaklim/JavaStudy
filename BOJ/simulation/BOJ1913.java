package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 		@ 달팽이
 *		@ https://www.acmicpc.net/problem/1913
 *		@ 
 */

public class BOJ1913 {

	static int n, target, curNb;
	static int[][] map;
	static Point ret;
	
	static void draw(Point p, int dir) {
		switch (dir) {
		case 0:	// down
			while (isValid(p.r + 1, p.c) && map[p.r + 1][p.c] == 0) {
				map[++p.r][p.c] = --curNb;
				if (curNb == target) {
					ret = new Point(p.r, p.c);
				}
			}
			break;
		case 1: // right
			while (isValid(p.r, p.c + 1) && map[p.r][p.c + 1] == 0) {
				map[p.r][++p.c] = --curNb;
				if (curNb == target) {
					ret = new Point(p.r, p.c);
				}
			}
			break;
		case 2: // up
			while (isValid(p.r - 1, p.c) && map[p.r - 1][p.c] == 0) {
				map[--p.r][p.c] = --curNb;
				if (curNb == target) {
					ret = new Point(p.r, p.c);
				}
			}
			break;
		case 3: // left
			while (isValid(p.r, p.c - 1) && map[p.r][p.c - 1] == 0) {
				map[p.r][--p.c] = --curNb;
				if (curNb == target) {
					ret = new Point(p.r, p.c);
				}
			}
			break;
		}
	}
	
	static boolean isValid(int r, int c) {
		if ((1 <= r && r <= n) && (1 <= c && c <= n))
			return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		target = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		
		int dir = 0;
		curNb = n * n + 1;
		Point p = new Point(0, 1);
		while (curNb != 1) {
			draw(p, dir++);
			dir %= 4;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 1; j < n; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append(map[i][n]).append("\n");
			bw.write(sb.toString());
		}
		StringBuilder sb = new StringBuilder();
		sb.append(ret.r).append(" ").append(ret.c).append("\n");
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}

class Point {
	int r, c;
	
	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}