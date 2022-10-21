package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 		@ 도토리 숨기기
 *		@ https://www.acmicpc.net/problem/15732
 *		@ 
 */

public class BOJ15732 {

	static int n, k, d;
	static ArrayList<Box> box;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		box = new ArrayList<>(k);
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int interval = Integer.parseInt(st.nextToken());
			box.add(new Box(from, to, interval));
		}
		
		int lo = 1, hi = n;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			long cnt = 0;
			for (int i = 0; i < box.size(); i++) {
				// mid 보다 왼쪽 박스
				if (box.get(i).to <= mid)
					cnt += (box.get(i).to - box.get(i).from) / box.get(i).interval + 1;
				// mid 보다 오른쪽 박스
				else if (box.get(i).from > mid)
					continue;
				// mid에 걸친 박스
				else
					cnt += (mid - box.get(i).from) / box.get(i).interval + 1; 
			}
			if (cnt < d)
				lo = mid + 1;
			else
				hi = mid - 1;
		}

		System.out.println(lo);
	}
	
	static class Box {
		int from, to, interval;
		
		Box(int from, int to, int interval) {
			this.from = from;
			this.to = to;
			this.interval = interval;
		}
	}
}