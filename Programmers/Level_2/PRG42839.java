package Level_2;

import java.util.HashSet;

/*
 * 		@ 소수 찾기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42839
 *		@ 소수: 1보다 큰 자연수 중 1과 자기자신만을 약수로 가지는 수
 */

public class PRG42839 {

	static HashSet<Integer> set = new HashSet<>();
	static char[] nums;
	static boolean[] visited;

	public int solution(String numbers) {

		nums = new char[numbers.length()];
		visited = new boolean[numbers.length()];

		for (int i = 0; i < numbers.length(); i++) {
			nums[i] = numbers.charAt(i);
		}
		
		solve("", 0);
		
		return set.size();
	}
	
	public void solve(String str, int idx) {
		int num;
		if (str != "") {
			num = Integer.parseInt(str);
			if (isPrime(num))
				set.add(num);
		}
		
		if (idx == nums.length)
			return;
		
		for (int i = 0; i < nums.length; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			solve(str + nums[i], idx + 1);
			visited[i] = false;
		}
	}
	
	public boolean isPrime(int num) {
		int i = 2;
		
		if (num < 2)
			return false;
		
		while (i * i <= num) {
			if (num % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}
}

		//에라토스테네스의 체
//		boolean[] isPrime = new boolean[10000000];
//		Arrays.fill(isPrime, 2, isPrime.length - 1, true);
//		for (int i = 2; i * 2 < isPrime.length; i++) {
//			if (!isPrime[i]) continue;
//			for (int j = i * 2; j < isPrime.length; j += i) {
//				isPrime[j] = false;
//			}
//		}
