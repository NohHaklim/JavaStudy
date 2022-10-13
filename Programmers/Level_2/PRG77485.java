package Level_2;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 		@ 행렬 테두리 회전하기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/77485
 *		@ 
 */

public class PRG77485 {
	public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length]; 
        
        int[][] board = new int[rows + 1][columns + 1];
        int n = 1;
        for (int i = 1; i <= rows; i++)
        	for (int j = 1; j <= columns; j++)
        		board[i][j] = n++;
        		
        int k = 0;
        for (int[] query : queries) {
        	Deque<Integer> dq = new ArrayDeque<>();
        	int fr = query[0];
        	int fc = query[1];
        	int tr = query[2];
        	int tc = query[3];
        	
        	int min = rows * columns + 1;
        	for (int i = fc; i <= tc; i++) {
        		dq.offerLast(board[fr][i]);
        		if (min > dq.peekLast())
        			min = dq.peekLast();
			}
			for (int i = fr + 1; i <= tr; i++) {
				dq.offerLast(board[i][tc]);
				if (min > dq.peekLast())
        			min = dq.peekLast();
			}
			for (int i = tc - 1; i >= fc; i--) {
				dq.offerLast(board[tr][i]);
				if (min > dq.peekLast())
        			min = dq.peekLast();
			}
			for (int i = tr - 1; i >= fr; i--) {
				dq.offerLast(board[i][fc]);
				if (min > dq.peekLast())
        			min = dq.peekLast();
			}
        	dq.offerFirst(dq.pollLast());
        	answer[k++] = min;
        	
        	for (int i = fc; i <= tc; i++)
        		board[fr][i] = dq.pollFirst();
        	for (int i = fr + 1; i <= tr; i++)
        		board[i][tc] = dq.pollFirst();
        	for (int i = tc - 1; i >= fc; i--)
        		board[tr][i] = dq.pollFirst();
        	for (int i = tr - 1; i >= fr; i--)
        		board[i][fc] = dq.pollFirst();
        }
        
        return answer;
    }
}
