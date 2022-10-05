package Level_3;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 		@ 이중우선순위큐
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42628
 */

class Data {
	public int data;
	public boolean deleted = false;
	
	public Data(int data) {
		this.data = data;
	}
}

public class PRG42628 {
	public int[] solution(String[] operations) {
        int[] answer;
        
        PriorityQueue<Data> pqMin = new PriorityQueue<>(new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				return o1.data - o2.data;
			}
		});
        PriorityQueue<Data> pqMax = new PriorityQueue<>(new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				return o2.data - o1.data;
			}
		});
        
        for (String operation : operations) {
        	String[] com = operation.split(" ");
        	switch (com[0]) {
        	case "I" :
        		Data data = new Data(Integer.parseInt(com[1]));
        		pqMin.offer(data);
        		pqMax.offer(data);
        		break;
        	case "D" :
        		if (com[1].equals("-1")) {
        			while (!pqMin.isEmpty() && pqMin.peek().deleted == true) {
        				pqMin.poll();
        			}
        			if (!pqMin.isEmpty()) {
        				pqMin.poll().deleted = true;	
        			}
        		} else {
        			while (!pqMax.isEmpty() && pqMax.peek().deleted == true) {
        				pqMax.poll();
        			}
        			if (!pqMax.isEmpty()) {
        				pqMax.poll().deleted = true;	
        			}
        		}
        		break;
        	}
        }
        
        
        while (!pqMin.isEmpty() && pqMin.peek().deleted == true) {
			pqMin.poll();
		}
        while (!pqMax.isEmpty() && pqMax.peek().deleted == true) {
			pqMax.poll();
		}
        
        if (pqMin.isEmpty()) {
        	answer = new int[] {0, 0};
        } else {
        	answer = new int[] {pqMax.poll().data, pqMin.poll().data};
        }
        
        return answer;
    }
}
