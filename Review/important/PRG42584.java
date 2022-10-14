package important;

import java.util.Stack;

/*
 * 		@ 주식가격
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */

//		스택에 증가하는 시점들을 넣어두고,
//		감소하는 시점이 등장하면 그 시점 - 스택의 top 시점을 answer에 넣는다.
public class PRG42584 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> s = new Stack<>();
		
		for (int i = 0; i < prices.length; i++) {
			while (!s.isEmpty() && prices[i] < prices[s.peek()]) {
				answer[s.peek()] = i - s.peek();
				s.pop();
			}
			s.push(i);
		}
		
		while (!s.isEmpty()) {
			answer[s.peek()] = prices.length - s.peek() - 1;
			s.pop();
		}
        return answer;
    }
}
