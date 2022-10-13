package Level_1;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 		@ 키패드 누르기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/67256
 *		@ 각 손이 위치한 번호를 저장해야 한다.
 *		@ * = 10, 0 = 11, # = 12
 *		@ 거리를 재는 함수 필요
 */

public class PRG67256 {

	static int[] where;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();

		where = new int[] { 9, 11 };
		for (int number : numbers) {
            if (number == 0)
                number = 11;
            number--;
            
			if (number == 0 || number == 3 || number == 6) {
				answer.append('L');
				where[0] = number;
			} else if (number == 2 || number == 5 || number == 8) {
				answer.append('R');
				where[1] = number;
			} else {
                int a = getDist(0, number);
			    int b = getDist(1, number);
                
                if (a < b) {
                    answer.append('L');
				    where[0] = number;
                } else if ( a > b) {
                    answer.append('R');
				    where[1] = number;
                } else {
                    if (hand.charAt(0) == 'l') {
					    answer.append('L');
					    where[0] = number;
				    } else {
					    answer.append('R');
					    where[1] = number;
				    }
                }
			}
		}

		return answer.toString();
	}

	// 0: left, 1: right
	static int getDist(int hand, int target) {
		boolean[][] visited = new boolean[4][3];
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(where[hand] / 3, where[hand] % 3, 0));

		while (!q.isEmpty()) {
			Point from = q.poll();

			if (from.r * 3 + from.c == target)
				return from.cnt;

			for (int dir = 0; dir < 4; dir++) {
				int nr = from.r + dr[dir];
				int nc = from.c + dc[dir];

				if ((0 <= nr && nr <= 3) && (0 <= nc && nc <= 2) && visited[nr][nc] == false) {
					visited[nr][nc] = true;
					q.offer(new Point(nr, nc, from.cnt + 1));
				}
			}
		}
		return -1;
	}

}

class Point {
	public int r, c, cnt;

	Point(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}
