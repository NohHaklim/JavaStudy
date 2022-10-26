package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 		@ 나는야 포켓몬 마스터 이다솜
 *		@ https://www.acmicpc.net/problem/1620
 *		@
 */

public class BOJ1620 {

	static int n, m;
	static String[] dict;
	static HashMap<String, Integer> getNb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dict = new String[n + 1];
		getNb = new HashMap<>(n);
		
		for (int i = 1; i <= n; i++) {
			dict[i] = br.readLine();
			getNb.put(dict[i], i);
		}

		for (int i = 0; i < m; i++) {
			String temp = br.readLine();
			if ('0' <= temp.charAt(0) && temp.charAt(0) <= '9') {
				System.out.println(dict[Integer.parseInt(temp)]); 
			} else {
				System.out.println(getNb.get(temp));
			}
		}
	}
}