package Level_1;

/*
 * 		@ 숫자 짝궁
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/131128
 */

public class PRG131128 {
	public String solution(String X, String Y) {
        
        int[] xflag = new int[10];
        int[] yflag = new int[10];
        for (int i = 0; i < X.length(); i++)
        	xflag[X.charAt(i) - '0']++;
        for (int j = 0; j < Y.length(); j++)
        	yflag[Y.charAt(j) - '0']++;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
        	int cnt = Math.min(xflag[i], yflag[i]);
        	while (cnt-- != 0)
        		sb.append(i);
        }
        	
        if (sb.length() == 0)
        	return "-1";
        if (sb.charAt(0) == '0')
        	return "0";
        return sb.toString();
    }
}
