package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 소수&팰린드롬
 *		@ https://www.acmicpc.net/problem/1747
 */

public class BOJ1747 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int nb = 0;
		
		while (true) {
			nb = nextPrime(N);
			if (isPalindrome(nb))
				break;
			N = nb + 1;
		}
		System.out.println(nb);
	}
	
	static boolean isPalindrome(int nb) {
		String number = Integer.toString(nb);
		int len = number.length();
		
		for (int i = 0; i < len / 2; i++)
			if (number.charAt(i) != number.charAt(len - 1 - i))
				return false;
		return true;
	}
	
	static boolean isPrime(int nb) {
		int i;
		
		if (nb < 2)
			return false;
		i = 2;
		while (i * i <= nb) {
			if (nb % i == 0)
				return false;
			i++;
		}
		return true;
	}
	
	static int nextPrime(int nb) {
		while (!isPrime(nb))
			nb++;
		return nb;
	}
}