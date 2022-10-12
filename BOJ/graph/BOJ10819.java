package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 차이를 최대로
 *		@ https://www.acmicpc.net/problem/10819
 */

public class BOJ10819 {

	static int N, Ret;
	static int[] Arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			Arr[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(permutation(new int[N], 0, 0, 0));
		
	}

	static int permutation(int[] selected, int idx, int used, int val) {
		if (idx == N)
			return val;

		int ret = 0;
		for (int i = 0; i < N; i++) {
			int temp = val;
			if ((used & (1 << i)) != 0)
				continue;
			selected[idx] = Arr[i];
			if (idx > 0)
				temp += Math.abs(selected[idx - 1] - selected[idx]); 
			ret = Math.max(ret, permutation(selected, idx + 1, used | (1 << i), temp));
		}
		return ret;
	}
}