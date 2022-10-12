package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 		@ 흙길 보수하기
 *		@ https://www.acmicpc.net/problem/1911
 */

public class BOJ1911 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		ArrayList<Water> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.add(new Water(from, to));
		}
		Collections.sort(list, (a, b) -> a.from - b.from);
		
		int blocked = -1, cnt = 0;
		for (Water w : list) {
			int from = Math.max(blocked, w.from);
			int to = w.to;
			int len = to - from;

			// 이미 덮은 경우
			if (len < 0)
				continue;
			
			// 알맞게 덮을 수 있는 길이
			cnt += len / L;
						
			// 더 덮어야 하는 길이
			if (len % L != 0) {
				cnt++;
				blocked = to + (L - (len % L));
			}
			
			
		}
		
		System.out.println(cnt);
	}
}

class Water {
	public int from;
	public int to;
	
	Water(int from, int to) {
		this.from = from;
		this.to = to;
	}
}

