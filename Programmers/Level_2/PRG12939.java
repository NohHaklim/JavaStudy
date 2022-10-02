package Level_2;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 		@ 최댓값과 최솟값
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12939
 */

public class PRG12939 {
	public String solution(String s) {
        
        String[] strs = s.split(" ");
        ArrayList<Integer> intArray = new ArrayList<>(strs.length);
        
        for (int i = 0; i < strs.length; i++) {
        	intArray.add(Integer.parseInt(strs[i]));
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append(Collections.min(intArray).toString());
        sb.append(" ");
        sb.append(Collections.max(intArray).toString());
        
        
        return sb.toString();
    }
}
