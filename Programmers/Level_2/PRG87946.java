package Level_2;

/*
 * 		@ 피로도
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42946
 *		@ 
 */

public class PRG87946 {

	static int answer;
	static boolean[] visited;

	public int solution(int k, int[][] dungeons) {
		answer = 0;
		visited = new boolean[dungeons.length];

		solve(k, 0, dungeons);

		return answer;
	}

	public void solve(int k, int cnt, int[][] dungeons) {
		boolean tired = true;
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && k >= dungeons[i][0]) {
				tired = false;
				break;
			}
		}
		if (tired) {
			answer = Math.max(answer, cnt);
			return;
		}

		//		이전 소스는 필요없는 소시인 듯?
		for (int i = 0; i < dungeons.length; i++) {
			if (visited[i])
				continue;
			if (k < dungeons[i][0])
				continue;
			visited[i] = true;
			solve(k - dungeons[i][1], cnt + 1, dungeons);
			visited[i] = false;
		}
	}
}
