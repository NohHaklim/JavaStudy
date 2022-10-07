package Level_2;

/*
 * 		@ 타겟 넘버
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/43165
 *		@ 
 */

public class PRG43165 {

	static int answer;

	public int solution(int[] numbers, int target) {
		
		solve(numbers, target, 0, 0);
		
		return answer;
	}

	public void solve(int[] numbers, int target, int sum, int idx) {
		if (idx == numbers.length) {
			if (target == sum) {
				answer++;
			}
			return;
		}

		solve(numbers, target, sum - numbers[idx], idx + 1);
		solve(numbers, target, sum + numbers[idx], idx + 1);

	}
}
