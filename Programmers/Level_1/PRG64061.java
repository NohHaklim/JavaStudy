package Level_1;

import java.util.Stack;

/*
 * 		@ 크레인 인형뽑기 게임
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/64061
 */

public class PRG64061 {
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> bucket = new Stack<>();
        
        for (int move : moves) {
        	int where = move - 1, doll = 0;
        	
        	for (int i = 0; i < board.length; i++) {
        		if (board[i][where] != 0) {
        			doll = board[i][where];
        			board[i][where] = 0;
        			break;
        		}
        	}
        	if (doll != 0) {
        		if (!bucket.isEmpty() && bucket.peek() == doll) {
        			answer += 2;
        			bucket.pop();
        		} else
        			bucket.push(doll);
        	}
        }
        
        return answer;
    }
}
