package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 		@ 잃어버린 괄호
 *		@ https://www.acmicpc.net/problem/1541
 *		@ 
 */

public class BOJ1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);

		ArrayList<Integer> operand = new ArrayList<>();
		operand.add(Integer.parseInt(st.nextToken()));
		int i = 0;
		while (st.hasMoreTokens()) {
			char ch = st.nextToken().charAt(0);
			if (ch == '+') {
				int a = operand.get(i);
				int b = Integer.parseInt(st.nextToken());
				operand.set(i, a + b);
			} else {
				int a = Integer.parseInt(st.nextToken());
				operand.add(a);
				i++;
			}
		}
		
		int ret = operand.get(0);
		for (int j = 1; j <= i; j++) {
			ret -= operand.get(j);
		}
		System.out.println(ret);

	}
}