package important;

/*
 * 		@ 쿼드압축 후 개수 세기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/68936
 *		@ 
 *		@ 
 */

public class PRG68936 {
	
	static int[][] Arr;
	static int[] Cnt = new int[2];
	
	public int[] solution(int[][] arr) {
        
		Arr = arr;
		
        divide(0, 0, arr.length);

        return Cnt;
    }
	
	static void divide(int r, int c, int size) {
        boolean[] flag = new boolean[3];
        flag[0] = false;
        flag[1] = false;
        flag[2] = true;
		
		for (int i = r; flag[2] && i < r + size; i++) {
			for (int j = c; flag[2] && j < c + size; j++) {
				if (Arr[i][j] == 1)
					flag[1] = true;
				else
					flag[0] = true;
                if (flag[0] == true && flag[1] == true)
                    flag[2] = false;
			}
		}
		
		if (flag[2] && flag[1]) {
			Cnt[1]++;
			return;
		}
		if (flag[2] && flag[0]) {
			Cnt[0]++;
			return;
		}

		divide(r, c, size / 2);
		divide(r, c + size / 2, size / 2);
		divide(r + size / 2, c, size / 2);
		divide(r + size / 2, c + size / 2, size / 2);
	}
}
