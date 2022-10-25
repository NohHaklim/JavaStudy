package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 		@ 서강그라운드
 *		@ https://www.acmicpc.net/problem/14938
 *		@
 */

public class BOJ14938 {

	static int n, m, r;
	static int[] item;
	static int[] dist;
	static ArrayList<ArrayList<Point>> adjs;
	
	static void dijk(int src) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(src, 0));
		dist[src] = 0;
		
		while (!pq.isEmpty()) {
			Point curr = pq.poll();
			for (Point next : adjs.get(curr.point)) {
				if (dist[next.point] > dist[curr.point]+ next.cost) {
					dist[next.point] = dist[curr.point] + next.cost;
					pq.offer(new Point(next.point, dist[next.point]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		item = new int[n];
		adjs = new ArrayList<>(n);
		dist = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			adjs.add(new ArrayList<Point>());
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			adjs.get(from).add(new Point(to, cost));
			adjs.get(to).add(new Point(from, cost));
		}
		
		int ret = 0;
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			dijk(i);
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if (dist[j] <= m)
					sum += item[j];
			}
			if (ret < sum)
				ret = sum;
		}
		System.out.println(ret);
	}
	
	static class Point implements Comparable<Point>{
		int point, cost;
		
		Point (int point, int cost) {
			this.point = point;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
}