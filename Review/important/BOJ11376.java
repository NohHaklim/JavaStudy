package important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 		@ 열혈강호 2
 *		@ https://www.acmicpc.net/problem/11376
 *		@ 
 */

public class BOJ11376 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> Adjs;
	static int[] A, B;
	static boolean[] Visited;

	static boolean isMatched(int a) {
		Visited[a] = true;
		for (int b : Adjs.get(a)) {
			if (B[b] == -1 || !Visited[B[b]] && isMatched(B[b])) {
				A[a] = b;
				B[b] = a;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Adjs = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			ArrayList<Integer> temp1 = new ArrayList<>();
			ArrayList<Integer> temp2 = new ArrayList<>();
			if (n != 0) {
				for (int j = 0; j < n; j++) {
					int data = Integer.parseInt(st.nextToken()) - 1;
					temp1.add(data);
					temp2.add(data);
				}
			}
			Adjs.add(temp1);
			Adjs.add(temp2);
		}
		N *= 2;
		A = new int[N];
		B = new int[M];
		Visited = new boolean[N];
		Arrays.fill(A, -1);
		Arrays.fill(B, -1);

		int match = 0;
		for (int i = 0; i < N; i++) {
			if (A[i] == -1) {
				Arrays.fill(Visited, false);
				if (isMatched(i))
					match++;	
			}
		}
		System.out.println(match);
	}
}