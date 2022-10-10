package Level_2;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * 		@ 오픈채팅방
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42888
 *		@ 
 */

public class PRG42888 {
	public String[] solution(String[] record) {
        
        ArrayList<String[]> ret = new ArrayList<>();
        HashMap<String, String> who = new HashMap<>();
        
        for (String r : record) {
        	String[] temp = r.split(" ");
        	
        	switch(temp[0].charAt(0)) {
        	case 'E':
        		who.put(temp[1], temp[2]);
        	case 'L':
        		ret.add(new String[] {temp[1], temp[0]});
        		break;
        	case 'C':
        		who.put(temp[1], temp[2]);
        		break;
        	}
        }
        
        int i = 0;
        String[] answer = new String[ret.size()];
        for (String[] r : ret) {
        	StringBuilder sb = new StringBuilder();
        	sb.append(who.get(r[0])); // nickname
        	if (r[1].charAt(0) == 'E') {
        		sb.append("님이 들어왔습니다.");
        	} else {
        		sb.append("님이 나갔습니다.");
        	}
        	answer[i++] = sb.toString();
        }
        
        return answer;
    }
}
