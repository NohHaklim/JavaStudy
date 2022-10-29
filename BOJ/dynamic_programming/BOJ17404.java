package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ RGB 거리 2
 *		@ https://www.acmicpc.net/problem/17404
 */

public class BOJ17404 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[][] cost = new int[n][];
		int[][] dp = new int[n][];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = new int[3];
			dp[i] = new int[3];
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int ret = 1000001;
		// 첫 번째 집의 색깔 = k
		for (int k = 0; k < 3; k++) {
			
			// 첫 집의 색을 정하고, 다른 색은 칠해지지 않도록 INF값 설정
			for (int i = 0; i < 3; i++) {
				if (i == k) {
					dp[0][i] = cost[0][i];
				} else {
					dp[0][i] = 1000001;
				}
			}
			
			for (int i = 1; i < n; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
			}
			
			for (int i = 0; i < 3; i++) {
				// 마지막 집 색이 첫 집 색과 같으면 continue
				if (i == k)
					continue;
				ret = Math.min(ret, dp[n - 1][i]);
			}
		}
		
		System.out.println(ret);
	}
}