package Level_1;

/*
 * 		@ 최소직사각형
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */

public class PRG86491 {
	public int solution(int[][] sizes) {
        
        int max = -1;
        int min = -1;
        for (int[] size : sizes) {
        	max = Math.max(max, Math.max(size[0], size[1]));
        	min = Math.max(min, Math.min(size[0], size[1]));
        }
        
        return min * max;
    }
}
