package Level_1;

/*
 * 		@ 연속된 수의 합
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/120923
 */

public class PRG120923 {
	public int[] solution(int num, int total) {
        int[] answer;

        int first = 1;
        int last = num;
        int sum = last * (last + 1) / 2;
//      (total - sum) / num + 1 이 시작점. 왜?
        while (sum != total) {
        	if (sum < total) {
        		sum -= first;
            	first++; last++;
            	sum += last;	
        	} else {
        		sum -= last;
        		first--; last--;
        		sum += first;
        	}
        }
        
        answer = new int[last - first + 1];
        for (int i = 0; i < answer.length; i++)
        	answer[i] = i + first;
        
        return answer;
    }
}	