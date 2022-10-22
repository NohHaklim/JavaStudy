package important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 회문
 *		@ https://www.acmicpc.net/problem/17609
 *		@
 */

public class BOJ17609 {

	static int n;
	
	static int isPalindrome(String line) {
		int left = 0, right = line.length() - 1;
		while (left < right) {
			if (line.charAt(left) == line.charAt(right)) {
				left++;
				right--;
			} else {
				int leftChk = palindrome(line.substring(left, right));
				int rightChk = palindrome(line.substring(left + 1, right + 1));
				if (leftChk == 1 || rightChk == 1) {
					return 1;
				} else {
					return 2;
				}
			}
		}
		return 0;
	}
	
	static int palindrome(String line) {
		int left = 0, right = line.length() - 1;
		while (left < right) {
			if (line.charAt(left) == line.charAt(right)) {
				left++;
				right--;
			} else {
				return 0;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			System.out.println(isPalindrome(st.nextToken()));
		}
	}
}