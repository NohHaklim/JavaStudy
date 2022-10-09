package Level_3;

/*
 * 		@ 등굣길
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42898
 *		@ 
 *		@ 
 */

public class PRG42898 {
public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int[] puddle : puddles)
        	dp[puddle[1]][puddle[0]] = -1;
        
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= m; j++) {
        		if (dp[i][j] == -1)
        			continue;
        		int a = dp[i][j - 1] != -1 ? dp[i][j - 1] : 0;
        		int b = dp[i - 1][j] != -1 ? dp[i - 1][j] : 0;
                
                if ((dp[i][j] += (a + b)) > 1000000007)
        		    dp[i][j] %= 1000000007;
        	}
        }
        
        return dp[n][m];
    }
}
