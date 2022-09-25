package _02;

import java.util.Scanner;

/*
 * 		@ 피보나치 수열을 출력하시오.
 * 
 */
public class Main {

	public static void main(String[] args) {
		long a, b, tmp;
		int i, n;
		Scanner sc;

		a = 0L;
		b = 1L;
		sc = new Scanner(System.in);

		System.out.println("몇 번째 피보나치 수까지 나열하나요?");
		while (true) {
			n = sc.nextInt();
			if ((n <= 0) || (n > 70)) {
				System.out.println("1 ~ 70 사이의 수를 입력해주세요");
			} else {
				break;
			}
		}
		sc.close();

		for (i = 1; i <= n; i++) {
			tmp = a;
			a = b + tmp;
			b = tmp;
			System.out.printf("%15d ", a);
			if (i % 3 == 0) {
				System.out.print("\n");
			}
		}
	}
}
