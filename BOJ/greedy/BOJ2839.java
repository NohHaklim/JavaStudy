package greedy;

import java.util.Scanner;

/*
 * 		@ 설탕 배달
 *		@ https://www.acmicpc.net/problem/2839
 */

public class BOJ2839 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = N / 5;
		int ret = 0;
		for (int i = k; i >= 0; i--) {
			int reserve = N - (5 * i);
			if (reserve % 3 == 0) {
				ret += reserve / 3;
				ret += i;
				break;
			}
		}
		
		if (ret == 0)
			ret = -1;
		sc.close();
		System.out.println(ret);
	}
}
