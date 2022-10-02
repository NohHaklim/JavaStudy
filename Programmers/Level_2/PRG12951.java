package Level_2;

/*
 * 		@ JadenCase 문자열 만들기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12951
 */

public class PRG12951 {
	class Solution {
	    public String solution(String s) {
	        StringBuilder sb = new StringBuilder(s);
	        boolean flag = true;
	        
	        for (int i = 0; i < s.length(); i++) {
	        	if (flag == true) {
	        		if (sb.charAt(i) == ' ') {
	                    continue;
	                }
	        		if ('a' <= sb.charAt(i) && sb.charAt(i) <= 'z') {
	        			sb.setCharAt(i, (char)(sb.charAt(i) - 32));
	        		}
	        		flag = false;
	        	} else if (sb.charAt(i) == ' ') {
	        		flag = true;
	        	} else if ('A' <= sb.charAt(i) && sb.charAt(i) <= 'Z') {
	        		sb.setCharAt(i, (char)(sb.charAt(i) + 32));
	        	}
	        }
	        
	        return sb.toString();
	    }
	}
}
