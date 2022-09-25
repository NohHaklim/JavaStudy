/*
 * 		@ 짝수와 홀수
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12937?language=java 
 */

import java.util.ArrayList;

class Solution {
	public String solution(int num) {
		ArrayList<String> list = new ArrayList<String>(2);
		list.add("Even");
		list.add("Odd");
		return list.get(num & 1);
	}
}