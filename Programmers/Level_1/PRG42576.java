package Level_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * 		@ 완주하지 못한 선수
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */

//		sort 후 비교

class PRG42576 {
    public String solution(String[] participant, String[] completion) {
    	
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i;
        for (i = 0; i < completion.length; i++) {
        	if (!completion[i].equals(participant[i])) {
        		break;
        	}
        }
        return participant[i];
    }
}

//		hash

class PRG42576_2 {
    public String solution(String[] participant, String[] completion) {
    	
    	String answer = "";
    	
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
        	map.put(player, map.getOrDefault(player, 0).intValue() + 1);
        }
        for (String player : completion) {
        	map.put(player, map.get(player).intValue() - 1);
        }
        
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        
        while (iter.hasNext()) {
        	Map.Entry<String, Integer> entry = iter.next();
        	if (entry.getValue() != 0) {
        		answer = entry.getKey();
        		break;
        	}
        }
        return answer;
    }
}