package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 		@ 친구 네트워크
 *		@ https://www.acmicpc.net/problem/4195
 *		@ 
 */

public class BOJ4195 {

	static int[] p;

	// 루트를 찾아 반환하는 연산
	static int find(int n) {
		if (p[n] < 0)
			return n;
		p[n] = find(p[n]);
		return p[n];

	}

	// 두 집합을 합치는 연산
	// 루트일 경우: -(집합 내 원소의 수)
	static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;
		p[a] += p[b];
		p[b] = a;
	}

	// 집합의 사이즈 리턴
	static int size(int n) {
		n = find(n);
		return Math.abs(p[n]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		while (tc-- != 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			HashMap<String, Integer> hm_id = new HashMap<>();
			p = new int[200000];
			int idNb = 0;
			Arrays.fill(p, -1);

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if (!hm_id.containsKey(a)) {
					hm_id.put(a, idNb++);
				}
				if (!hm_id.containsKey(b)) {
					hm_id.put(b, idNb++);
				}
				merge(hm_id.get(a), hm_id.get(b));
				System.out.println(size(hm_id.get(a)));
			}
		}
	}
}