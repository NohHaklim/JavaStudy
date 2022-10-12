package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 걷기
 *		@ https://www.acmicpc.net/problem/1459
 */

public class BOJ1459 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		long ret = 0;
		int mid = Math.min(x, y);
		int last = Math.max(x, y) - mid;
		
		ret += Math.min((long)mid * 2 * w, (long)mid * s);
		if ((last & 1) == 1) {
			ret += w;
			last--;
		}
		ret += Math.min((long)last * w, (long)last * s);
		System.out.println(ret);
		
	}
}
