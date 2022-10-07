package __03bit;

import java.util.*;

public class BitExample2 {

	static int N;
	static int[] Set;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Set = new int[N];
		for (int i = 0; i < N; i++)
			Set[i] = sc.nextInt();
		
//		두 수의 합이 7이 되는 부분 집합 구하기.
		solve();
		
		sc.close();
	}
	
	static void solve() {
		int ret = 0;
		for (int i = 0; i < (1 << N); i++) {
			if (Integer.bitCount(i) != 2)
				continue;
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) != 0) {
					sum += Set[j];
				}
			}
			if (sum == 7)
				ret++;
		}
		System.out.println(ret);
	}

}
