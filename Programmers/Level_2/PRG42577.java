package Level_2;

import java.util.HashMap;

/*
 * 		@ 전화번호 목록
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */

public class PRG42577 {
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
        	map.put(phone_book[i], false);
        }
        
        for (int i = 0; i < phone_book.length; i++) {
        	for (int j = 0; j < phone_book[i].length(); j++) {
        		if (map.containsKey(phone_book[i].substring(0, j))) {
        			answer = false;
        		}
        	}
        }
        
        return answer;
    }
}
