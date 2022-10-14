package important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 		@ 스카이라인 쉬운거
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/1863
 *		@ 
 *		@ 
 */

public class BOJ1863 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int cnt = 0;
		Stack<Integer> s = new Stack<>();
		s.push(0);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int h = Integer.parseInt(st.nextToken());
			int cur = s.peek();

			if (cur < h) {
				cnt++;
				s.push(h);
			} else if (cur > h) {
				while (s.peek() > h)
					s.pop();
				if (s.peek() < h) {
					cnt++;
					s.push(h);
				}
			}
		}
		System.out.println(cnt);
	}
}