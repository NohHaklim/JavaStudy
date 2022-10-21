package bipartite_matching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 		@ 열혈강호
 *		@ https://www.acmicpc.net/problem/11375
 *		@ 
 */

public class BOJ11375 {

	static int N, M;
	static int[] Worker, Work;
	static ArrayList<ArrayList<Integer>> Adjs;
	static boolean[] Visited;

	public static boolean match(int i) {
		Visited[i] = true;
		for (int j : Adjs.get(i)) {
			// 1. i와 이을 수 있는 Work인 j가 아직 이어지지 않았을 경우
			// 2. 이미 이어져있지만, j와 연결된 Work가 다른 일을 선택하는 경우
			if (Work[j] == -1 || Visited[Work[j]] == false && match(Work[j])) {
				Worker[i] = j;
				Work[j] = i;
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
			int nb = Integer.parseInt(st.nextToken());
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = 0; j < nb; j++) {
				temp.add(Integer.parseInt(st.nextToken()) - 1);
			}
			Adjs.add(temp);
		}

		int ret = 0;
		Worker = new int[N];
		Work = new int[M];
		Visited = new boolean[N];
		Arrays.fill(Worker, -1);
		Arrays.fill(Work, -1);
		
		for (int i = 0; i < N; i++) {
			if (Worker[i] == -1) {
				Arrays.fill(Visited, false);
				if (match(i))
					ret++;
			}
		}
		
		System.out.println(ret);
	}
}