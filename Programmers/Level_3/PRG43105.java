package Level_3;

/*
 * 		@ 정수 삼각형
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */

public class PRG43105 {
	public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for (int r = 1; r < triangle.length; r++) {
        	for (int c = 0; c < triangle[r].length; c++) {
        		if (c == 0) {
        			dp[r][c] = dp[r - 1][0] + triangle[r][c];
        		} else if (c == triangle[r].length - 1) {
        			dp[r][c] = dp[r - 1][r - 1] + triangle[r][c];
        		} else {
        			dp[r][c] = Math.max(dp[r - 1][c - 1], dp[r - 1][c]) + triangle[r][c];
        		}
        	}
        }
        
        for (int i = 0; i < triangle.length; i++) {
        	answer = Math.max(dp[triangle.length - 1][i], answer);
        }
        
        return answer;
    }
}
