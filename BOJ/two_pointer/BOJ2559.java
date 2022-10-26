package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 수열
 *		@ https://www.acmicpc.net/problem/2559
 *		@
 */

public class BOJ2559 {

	static int n, k;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = k - 1, ret = 0;
		for (int i = left; i <= right; i++) {
			ret += arr[i];
		}
		int sum = ret;
		while (right  + 1 < n) {
			sum = sum - arr[left] + arr[right + 1];
			left++;
			right++;
			if (sum > ret)
				ret = sum;
		}
		System.out.println(ret);
	}
}