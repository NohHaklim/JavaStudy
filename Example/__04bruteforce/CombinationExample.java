package __04bruteforce;

//			조합 Combination
//			선택 순서가 결과에 영향을 주지 않는 경우.
//			ex) 두 수의 합이 가장 큰 경우를 구하라.

public class CombinationExample {

	static int N = 4;
	static int[] Nums = { 1, 2, 3, 4 };

	static int solve(int pos, int cnt, int val) {
		if (cnt == 2)
			return val;
		if (pos == N)
			return -1;
		
		int ret = 0;
		ret = Math.max(ret, solve(pos + 1, cnt + 1, val + Nums[pos]));
		ret = Math.max(ret, solve(pos + 1, cnt, val));
		
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(solve(0, 0, 0));
	}

}
