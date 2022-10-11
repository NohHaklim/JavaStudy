package Level_1;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 		@ 실패율
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42889
 */

public class PRG42889 {
public int[] solution(int N, int[] stages) {
        
        double[] failureRate = new double[N];
        int sum = 0, j = 0;
        Arrays.sort(stages);
        for (int i = 0; i < N; i++) {
        	int cnt = 0;
        	for (; j < stages.length; j++) {
        		if (stages[j] == i + 1)
        			cnt++;
                else
                    break;
        	}
        	if (sum == stages.length)
        		failureRate[i] = 0;
        	else
        		failureRate[i] = (double)cnt / (stages.length - sum);
        	sum += cnt;
        }
        
        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++)
        	idx[i] = i;
        
        Arrays.sort(idx, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (failureRate[o2] == failureRate[o1])
					return o1 - o2;
				else
					return (failureRate[o2] - failureRate[o1]) > (0) ? (1) : (-1);
			}
		});
        
        return Arrays.stream(idx).mapToInt(i->i + 1).toArray();
    }
}
