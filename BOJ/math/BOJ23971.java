package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ ZOAC4
 *		@ https://www.acmicpc.net/problem/23971
 *		@ 
 */

public class BOJ23971 {

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int h = (N - 1) / (r + 1) + 1;
		int w = (M - 1) / (c + 1) + 1;
		
		System.out.println(h * w);
	}
}