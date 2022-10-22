package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 수들의 합 2
 *		@ https://www.acmicpc.net/problem/2003
 *		@
 */

public class BOJ2003 {

	static int n, m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int res = 0, sum = 0, from = 0, to = 0;
		while (true) {
			if (sum >= m)
				sum -= arr[from++];
			else if (to == n)
				break;
			else
				sum += arr[to++];
			if (sum == m)
				res++;
		}
		System.out.println(res);
	}
}