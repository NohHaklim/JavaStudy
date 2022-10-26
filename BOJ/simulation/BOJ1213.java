package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 		@ 팰린드롬 만들기
 *		@ https://www.acmicpc.net/problem/1213
 *		@ 문자열 개수 다 센 다음에, 앞에서부터 채워 넣으면 안되나?
 *		@ 만약 홀수 짜리가 두 개 이상이면 ㅈㅈ
 *		@ 1. 한 번 훑으면서 2개 이상인 경우, 한 문자씩 넣기. (사전 순서 우선이기 때문에 앞에서 부터 훑기)
 *		@ 2. 한 번 더 훑으면서 1개짜리 중앙에 넣기.
 */

public class BOJ1213 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] cnt = new int[26];
		String line = br.readLine();
		for (int i = 0; i < line.length(); i++) {
			cnt[line.charAt(i) - 'A']++;
		}
		
		StringBuilder sb = new StringBuilder();
		char last = 'a';
		for (int i = 0; i < 26; i++) {
			if (cnt[i] >= 2) {
				int n = cnt[i] / 2;
				cnt[i] = cnt[i] % 2;
				for (int j = 0; j < n; j++) {
					sb.append((char) (i + 'A'));
				}
			}
			if (cnt[i] == 1 && last != 'a') {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
			if (cnt[i] == 1 && last == 'a')
				last = (char) (i + 'A');
		}
		StringBuilder temp = new StringBuilder(sb).reverse();
		if (last != 'a')
			sb.append(last);
		System.out.println(sb.append(temp));
	}
}