package important;

import java.util.*;

/*
 * 		@ 주차 요금 계산
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */

public class PRG92341 {
	
	public int[] solution(int[] fees, String[] records) {
        int[] answer;
        
        HashMap<String, Integer> entranceTime = new HashMap<>();
        HashMap<String, Integer> totalTime = new HashMap<>();
        
        for (String record : records) {
        	String[] temp = record.split(" ");
        	
        	int time = convert(temp[0]);
        	if (temp[2].equals("IN")) {
        		entranceTime.put(temp[1], time);
        	} else {
        		totalTime.put(temp[1], totalTime.getOrDefault(temp[1], 0) + time - entranceTime.get(temp[1]));
        		entranceTime.remove(temp[1]);
        	}
        }
        
        Iterator<String> iter = entranceTime.keySet().iterator();
        while (iter.hasNext()) {
        	String car = iter.next();
        	int time = entranceTime.get(car);
        	totalTime.put(car, totalTime.getOrDefault(car, 0) + 1439 - time);
        }
        
        iter = totalTime.keySet().iterator();
        ArrayList<Fee> list = new ArrayList<>();
        while (iter.hasNext()) {
        	String car = iter.next();
        	int time = totalTime.get(car);
        	int fee = 0;
        	time = time - fees[0] >= 0 ? time - fees[0] : 0;
        	fee += fees[1];
        	if (time != 0)
        		fee += (int)Math.ceil((double)time / fees[2]) * fees[3];
        	list.add(new Fee(car, fee));
        }
        
        Collections.sort(list, new Comparator<Fee>() {

			@Override
			public int compare(Fee o1, Fee o2) {
				return o1.car.compareTo(o2.car);
			}
        });
        
        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i).fee;
        }
        return answer;
    }
	
	static int convert(String time) {
		String[] hm = time.split(":");
		int ret = Integer.parseInt(hm[0]) * 60;
		ret += Integer.parseInt(hm[1]);
		return ret;
	}
}

class Fee {
	String car;
	int fee;
	
	public Fee(String car, int fee) {
		this.car = car;
		this.fee = fee;
	}
}


//import java.util.*;
//
//class Solution {
//
//    public int timeToInt(String time) {
//        String temp[] = time.split(":");
//        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
//    }
//    public int[] solution(int[] fees, String[] records) {
//
//        TreeMap<String, Integer> map = new TreeMap<>();
//
//        for(String record : records) {
//            String temp[] = record.split(" ");
//            int time = temp[2].equals("IN") ? -1 : 1;
//            time *= timeToInt(temp[0]);
//            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
//        }
//        int idx = 0, ans[] = new int[map.size()];
//        for(int time : map.values()) {
//            if(time < 1) time += 1439;
//            time -= fees[0];
//            int cost = fees[1];
//            if(time > 0)
//                cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2]+1)*fees[3];
//
//            ans[idx++] = cost;
//        }
//        return ans;
//    }
//}