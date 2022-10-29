package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 연속합 2
 *		@ https://www.acmicpc.net/problem/13398
 */

public class BOJ13398 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[][] dp = new int[2][];
		for (int i = 0; i < 2; i++) {
			dp[i] = new int[n];
		}
		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		dp[0][0] = arr[0];
		dp[1][0] = arr[0];
		int ret = Math.max(dp[0][0], dp[1][0]);
		for (int i = 1; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			// dp[0][i] = i까지 올 때, 연속된 자연수들의 합 중 가장 큰 것.
			dp[0][i] = Math.max(dp[0][i - 1] + arr[i], arr[i]);
			// dp[1][i] = i까지 올 때, 하나를 제거했을 때, 연속된 자연수들의 합 중 가장 큰 것. 
			// max(현재 수를 제거, 이전에 제거한 경우: 현재 것 선택)
			dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + arr[i]);
			ret = Math.max(ret, Math.max(dp[0][i], dp[1][i]));
		}
		System.out.println(ret);
	}
}