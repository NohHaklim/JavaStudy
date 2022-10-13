package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 		@ 파티
 *		@ https://www.acmicpc.net/problem/1238
 *		@ i -> K, K -> i 가 최대인 i 구하기
 */

public class BOJ1238 {

	static final int INF = 987654321;
	static int N, M, K;
	static ArrayList<Cost> Adjs[];
	static int[] Dist;

	static void dijkstra(int src) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			Dist[i] = INF;
		Dist[src] = 0;

		pq.add(new int[] { 0, src });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int u = curr[1];

			if (visited[u])
				continue;
			visited[u] = true;
			for (Cost c : Adjs[u]) {
				if (Dist[c.v] > Dist[u] + c.cost) {
					Dist[c.v] = Dist[u] + c.cost;
					pq.offer(new int[] { Dist[c.v], c.v });
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Adjs = new ArrayList[N + 1];
		Dist = new int[N + 1];

		for (int i = 1; i <= N; i++)
			Adjs[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			Adjs[u].add(new Cost(v, cost));
		}
		
		int ret = 0;
		for (int i = 1; i <= N; i++) {
			dijkstra(i);
			int a = Dist[K];
			dijkstra(K);
			int b = Dist[i];
			ret = Math.max(ret, a + b);
		}
		
		System.out.println(ret);
	}
}

class Cost {
	int v, cost;
	
	Cost(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
}