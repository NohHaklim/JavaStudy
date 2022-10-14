package important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 		@ A와 B 2
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12919
 *		@ 
 *		@ 
 */

public class BOJ12919 {
	
	static String S, T;
	
	static int BFS(String x) {
		Queue<String> q = new LinkedList<>();
		q.offer(x);
		
		int ret = 0;
		while (!q.isEmpty()) {
			String from = q.poll();
			
			if (S.length() == from.length() && S.equals(from)) {
				ret = 1;
				break;
			}
			if (S.length() > from.length())
				break;
				
			if (from.endsWith("A"))
				q.offer(from.substring(0, from.length() - 1));
			if (from.startsWith("B")) {
				StringBuilder temp = new StringBuilder(from);
				q.offer(temp.reverse().substring(0, temp.length() - 1));
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		T = br.readLine();

		System.out.println(BFS(T));
	}
}