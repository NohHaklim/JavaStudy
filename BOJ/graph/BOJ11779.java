package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 		@ 최소비용 구하기2
 *		@ https://www.acmicpc.net/problem/11779
 *		@
 */

public class BOJ11779 {

	static int n, m;
	static int[] dist, route;
	static List<Integer> path;
	static ArrayList<ArrayList<Point>> adjs;
	
	static void dijk(int src, int dst) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(src, 0));
		dist[src] = 0;
		
		while (!pq.isEmpty()) {
			Point curr = pq.poll();
			
			// 다른 비용의 노선이 중복해서 들어올 수도 있음
			if (dist[curr.point] < curr.cost)
				continue;
			
			for (Point next : adjs.get(curr.point)) {
				if (dist[next.point] > dist[curr.point]+ next.cost) {
					route[next.point] = curr.point;
					dist[next.point] = dist[curr.point] + next.cost;
					pq.offer(new Point(next.point, dist[next.point]));
				}
			}
		}
		
		int node = dst;
		while (node != 0) {
			path.add(node);
			node = route[node];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		
		adjs = new ArrayList<>();
		route = new int[n + 1];
		path = new LinkedList<>();
		dist = new int[n + 1];
		
		for (int i = 0; i < n + 1; i++) {
			adjs.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjs.get(u).add(new Point(v, cost));
		}
		st = new StringTokenizer(br.readLine());
		int src = Integer.parseInt(st.nextToken());
		int dst = Integer.parseInt(st.nextToken());
		
		dijk(src, dst);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(dist[dst]).append("\n");
		sb.append(path.size()).append("\n");
		for (int i = path.size() - 1; i >= 0; i--) {
			sb.append(path.get(i)).append(" ");
		}
		System.out.println(sb.toString());
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