package important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 나머지 합
 *		@ https://www.acmicpc.net/problem/10986
 *		@ 이런 문제 풀 때 식으로 생각해보기
 *		@ [s, e) % m == 0
 *		@ (pSum[e] - pSum[s]) % m == 0
 *		@ pSum[e] % m == pSum[s] % m
 */

public class BOJ10986 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		int[] cnt = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sum = (sum + temp) % m;
			cnt[sum]++;
		}
		
		long ret = cnt[0];
		for (int i = 0; i < m; i++) {
			ret += (long) cnt[i] * (cnt[i] - 1) / 2;
		}
		System.out.println(ret);
	}
}