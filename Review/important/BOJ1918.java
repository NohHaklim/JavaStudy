package important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 		@ 후위 표기식
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/1918
 *		@ 
 *		@ 1. 'A' ~ 'Z'는 그대로 출력한다.
 *		@ 2. 우선순위 	0: '('
 *		@	 		1: '+' '-'
 *		@  			2: '*' '/'
 *		@ 3. 연산자는 해당 연산자보다 우선순위가 낮은 것들을 모두 출력한다. (스택이 비어있거나 '('를 만날 때까지)
 *		@ 4. 모두 출력
 *
 */

public class BOJ1918 {

	static String S, P;

	static int prior(char ch) {
		if (ch == '(')
			return 0;
		else if (ch == '+' || ch == '-')
			return 1;
		else if (ch == '*' || ch == '/')
			return 2;
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cmd = br.readLine();
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < cmd.length(); i++) {
			char ch = cmd.charAt(i);

			if ('A' <= ch && ch <= 'Z')
				System.out.print(ch);
			else if (ch == '(') {
				s.push(ch);
			} else if (ch == ')') {
				while (s.peek() != '(')
					System.out.print(s.pop());
				s.pop();
			} else {
				while (!s.isEmpty() && prior(s.peek()) >= prior(ch)) {
					System.out.print(s.pop());
				}
				s.push(ch);
			}
		}
		while (!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}
}