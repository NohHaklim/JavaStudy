package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 		@ 공항
 *		@ https://www.acmicpc.net/problem/10775
 *		@ 
 */

public class BOJ10775 {

	static int gate, plane;
	static int[] docking;

	static int find(int n) {
		if (docking[n] < 0)
			return n;
		docking[n] = find(docking[n]);
		return docking[n];
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;
		docking[a] += docking[b];
		docking[b] = a;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		gate = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		plane = Integer.parseInt(st.nextToken());
		docking = new int[gate + 1];
		Arrays.fill(docking, -1);
		int cnt = 0;
		for (int i = 1; i <= plane; i++) {
			st = new StringTokenizer(br.readLine());
			// 1번 ~ g번 게이트에 도킹하고 싶어!
			int g = Integer.parseInt(st.nextToken());
			g = find(g);
			if (g != 0 && docking[g] < 0) {
				cnt++;
				union(g - 1, g);
			} else
				break;
		}
		System.out.println(cnt);
	}
}