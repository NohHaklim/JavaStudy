package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 차량 번호판 1
 *		@ https://www.acmicpc.net/problem/16968
 *		@ 같은 문자 연속되는 건 불가능.
 */

public class BOJ16968 {

	static String in;
	static int len;

	static int combination(int idx, String str) {
		if (idx == len) {
			return 1;
		}

		
		int ret = 0;
		if (in.charAt(idx) == 'd') {
			for (int i = 0; i <= 9; i++) {
				StringBuilder sb = new StringBuilder(str);
				if (str.endsWith(Integer.toString(i)))
					continue;
				ret += combination(idx + 1, sb.append(i).toString());
			}
		} else {
			for (int i = 0; i <= 25; i++) {
				StringBuilder sb = new StringBuilder(str);
				if (str.endsWith(Character.toString(i + 'a')))
					continue;
				ret += combination(idx + 1, sb.append(Character.toString(i + 'a')).toString());
			}
		}
		return ret;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		in = st.nextToken();
		len = in.length();
		System.out.println(combination(0, ""));
	}
}