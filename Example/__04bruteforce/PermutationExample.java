package __04bruteforce;

//			순열 Permutation
//			선택 순서가 결과에 영향을 미치는 경우.
//			ex) 만들 수 있는 가장 큰 두 자리 수를 구하라.

public class PermutationExample {

	static int N = 4;
	static int[] Nums = { 1, 2, 3, 4 };

	static int solve(int cnt, int used, int val) {
		if (cnt == 2)
			return val;
		
		int ret = 0;
		for (int i = 0; i < N; i++) {
			if ((used & 1 << i) != 0)
				continue;
			ret = Math.max(ret, solve(cnt + 1, used | 1 << i, val * 10 + Nums[i]));
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(solve(0, 0, 0));
	}
}
