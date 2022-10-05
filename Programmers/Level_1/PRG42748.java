package Level_1;

import java.util.Arrays;

/*
 * 		@ K번째 수
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */

public class PRG42748 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		int i = 0;
		for (int[] command : commands) {
			command[0]--;
			command[1]--;
			answer[i++] = sort(array, command);
		}
		
		return answer;
	}

	public int sort(int[] array, int[] command) {
		int[] temp = new int[command[1] - command[0] + 1];
		int j = 0;
		for (int i = command[0]; i <= command[1]; i++) {
			temp[j++] = array[i];
		}
		Arrays.sort(temp);
		return temp[command[2] - 1];
	}
}
