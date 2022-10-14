package important;

/*
 * 		@ 삼각 달팽이
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/68645
 *		@ 
 *		@ 
 */

public class PRG68645 {
	
	static int[][] Arr;
	static int r, c, dir, value;
	
	public int[] solution(int n) {
        
        Arr = new int[n][];
        for (int i = 0; i < n; i++)
        	Arr[i] = new int[i + 1];
        
        r = -1;
        while (n != 0) {
        	// (r, c)에서 dir 방향으로 n이동하며 value 입력
        	move(n);
        	dir = (dir + 1) % 3;
        	n--;
        }
        
        int[] answer = new int[value];
        int idx = 0;
        for (int i = 0; i < Arr.length; i++) {
        	for (int j = 0; j < Arr[i].length; j++) {
        		answer[idx] = Arr[i][j];
        		idx++;
        	}
        }
        
        return answer;
    }
	
	static void move(int n) {
		switch (dir) {
		case 0: // 아래쪽
			for (int i = 0; i < n; i++) {
				Arr[++r][c] = ++value;
			}
			break;
		case 1: // 오른쪽
			for (int i = 0; i < n; i++) {
				Arr[r][++c] = ++value;
			}
			break;
		case 2: // 대각선 왼쪽 위로.
			for (int i = 0; i < n; i++) {
				Arr[--r][--c] = ++value;
			}
			break;
		}
	}
}
