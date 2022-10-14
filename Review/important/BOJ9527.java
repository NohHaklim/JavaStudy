package important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 1의 개수 세기
 *		@ https://www.acmicpc.net/problem/9527
 *		@ 
 */

public class BOJ9527 {
	
	static long A, B;
	static long[] D = new long[55];
	
	static long cal(long x) {
		long ret = x & 1;
		int i = 54;
		
		for (; i > 0; i--) {
			if ((x & (1L << i)) != 0) {
				ret += D[i - 1] + (x - (1L << i) + 1);
				x -= 1L << i;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		D[0] = 1L;
		for (int i = 1; i < 55; i++) {
			D[i] = D[i - 1] * 2 + (1L << i);
		}
		
		System.out.println(cal(B) - cal(A - 1));
	}
}