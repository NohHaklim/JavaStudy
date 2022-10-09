package Level_1;

import java.util.Arrays;

/*
 * 		@ 순열 검사
 *		@ https://school.programmers.co.kr/learn/courses/18/lessons/1877
 *		@ 
 *		@ 
 */

public class PRG1877 {
	public boolean solution(int[] arr) {

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] != i + 1)
        		return false;
        }
        
        return true;
    }
}
