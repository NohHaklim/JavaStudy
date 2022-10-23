package important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 1, 2, 3 더하기 4
 *		@ https://www.acmicpc.net/problem/15989
 *		@
 */

public class BOJ15989 {

	// dp[n][k] = 마지막 수로 k를 더했을 때 n이 된 경우의 수
	// dp[n][1] = dp[n - 1][1]
	// dp[n][2] = dp[n - 2][1] + dp[n - 2][2]
	// dp[n][3] = dp[n - 3][1] + dp[n - 3][2] + dp[n - 3][3]
	static int[][] dp = new int[10001][4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		dp[1][1] = 1;		// 1
		dp[2][1] = 1;		// 1 + 1
		dp[2][2] = 1;		// 2
		dp[3][1] = 1;		// 1 + 1 + 1
		dp[3][2] = 1;		// 1 + 2
		dp[3][3] = 1;		// 3
		
		for (int i = 4; i <= 10000; i++) {
			// 이전 수의 마지막 수보다 큰 것만 추가하면 중복 제거 가능
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
		}
		
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- != 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
		}
	}
}