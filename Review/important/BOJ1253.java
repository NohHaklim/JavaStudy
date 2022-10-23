package important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 		@ 좋다
 *		@ https://www.acmicpc.net/problem/1253
 *		@
 */

public class BOJ1253 {

	static int n;
	static int[] arr;
	static HashMap<Integer, HashSet<Integer>> hm;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		hm = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (hm.containsKey(arr[i]))
				hm.get(arr[i]).add(i);
			else {
				HashSet<Integer> temp = new HashSet<>();
				temp.add(i);
				hm.put(arr[i], temp);
			}
		}

		int ret = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = arr[i] + arr[j];
				int cnt = 0;
				HashSet<Integer> temp = new HashSet<>();
				if (!hm.containsKey(sum))
					continue;
				if (hm.get(sum).contains(i)) {
					cnt++;
					temp.add(i);
				}
				if (hm.get(sum).contains(j)) {
					cnt++;
					temp.add(j);
				}
				ret += hm.get(sum).size() - cnt;
				hm.put(sum, temp);
			}
		}

		System.out.println(ret);
	}
}