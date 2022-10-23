package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 퇴사 2
 *		@ https://www.acmicpc.net/problem/15486
 *		@
 */

public class BOJ15486 {

	static int n, ret;
	static int[] dp = new int[1500001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken()) - 1;
			int profit = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i], dp[i - 1]);
			if (i + to <= n)
				dp[i + to] = Math.max(dp[i + to], dp[i - 1] + profit);
			ret = Math.max(ret, dp[i]);
		}
		System.out.println(ret);
	}
}