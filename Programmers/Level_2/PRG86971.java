package Level_2;

import java.util.Arrays;

/*
 * 		@ 전력망을 둘로 나누기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/86971
 *		@ 
 */

public class PRG86971 {

	static int N;
	static boolean[][] map;
	static boolean[] visited;

	public int solution(int n, int[][] wires) {
		int answer = 100;

		N = n;
		n++;
		map = new boolean[n][n];
		visited = new boolean[n];
		for (int[] wire : wires) {
			map[wire[0]][wire[1]] = map[wire[1]][wire[0]] = true;
		}

//      i번 째 줄을 잘랐을 경우.
		for (int[] wire : wires) {
			map[wire[0]][wire[1]] = map[wire[1]][wire[0]] = false;
			int a = 0;
			for (int i = 1; i < map.length; i++) {
				if (visited[i])
					continue;
				a = find(i);
				break;
			}

			answer = Math.min(answer, Math.abs(a - (N - a)));
			Arrays.fill(visited, false);
			map[wire[0]][wire[1]] = map[wire[1]][wire[0]] = true;

		}

		return answer;
	}

	public int find(int from) {
		int cnt = 1;
		visited[from] = true;
		for (int to = 1; to < map.length; to++) {
			if (!visited[to] && map[from][to]) {
				cnt += find(to);
			}
		}
		return cnt;
	}
}
