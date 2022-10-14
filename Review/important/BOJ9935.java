package important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * 		@ 문자열 폭발
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/9935
 *		@ 
 *		@ 
 */

public class BOJ9935 {

	static String S, P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		P = br.readLine();
		int len = P.length();
		Deque<Character> dq = new ArrayDeque<>();
		Stack<Character> s = new Stack<>();
		
		for (int i = 0; i < S.length(); i++) {
			dq.offerLast(S.charAt(i));
			
			if (dq.size() >= len && dq.peekLast() == P.charAt(len - 1)) {
				for (int j = 1; j <= len; j++) {
					if (dq.peekLast().charValue() == P.charAt(len - j))
						s.push(dq.pollLast());
					else {
						while (!s.isEmpty())
							dq.offerLast(s.pop());
						break;
					}
				}
				s.clear();
			}
		}
		
		if (dq.isEmpty())
			S = "FRULA";
		else {
			StringBuilder sb = new StringBuilder();
			while (!dq.isEmpty())
				sb.append(dq.pollFirst());
			S = sb.toString();
		}
			
		System.out.println(S);
	}
}