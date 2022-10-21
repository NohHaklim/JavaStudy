package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 		@ 과제
 *		@ https://www.acmicpc.net/problem/13904
 *		@ 
 */

public class BOJ13904 {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		// 1. 점수가 높은 순으로 저장.
		PriorityQueue<Work> works = new PriorityQueue<>((a, b) -> b.score - a.score);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			works.add(new Work(day, score));
		}
		
		// 2. 높은 점수의 과제를 최대한 마지막에 처리하도록 로직 작성.
		// 		day는 최대 1000이 들어올 수 있으므로, 처리하는 날 배열의 최댓값을 1001로 설정
		int[] process = new int[1001];
		while (!works.isEmpty()) {
			Work work = works.poll();
			int day = work.day;
			if (process[day] == 0) {
				process[day] = work.score;
			} else {
				while (day != 0) {
					if (process[--day] == 0) {
						process[day] = work.score;
						break;
					}
				}
			}
		}
		
		int ret = 0;
		for (int i = 1; i <= 1000; i++) {
			if (process[i] != 0) {
				ret += process[i];
			}
		}
		System.out.println(ret);
	}
}

class Work {
	int day, score;
	
	Work(int day, int score) {
		this.day = day;
		this.score = score;
	}
}