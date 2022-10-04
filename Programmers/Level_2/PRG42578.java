package Level_2;

/*
 * 		@ 위장
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */

import java.util.HashMap;
import java.util.Iterator;

public class PRG42578 {
	public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
        	String type = cloth[1];
        	map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
        	answer *= it.next().intValue() + 1;
        }
        return answer - 1;
    }
}

//
//		return Arrays.stream(clothes)
//					.collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
//					.values()
//					.stream()
//					.collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
//
