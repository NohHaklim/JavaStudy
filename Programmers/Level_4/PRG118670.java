package Level_4;

import java.util.*;

/*
 * 		@ 행렬과 연산
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/118670
 *		@ deque 배열
 *		@ 



		정확성: 25(만점) / 효율성 41.7 / 합계: 66.7
		to, to, 48, to, 53, to, 57, 56, 80
		idx를 deque로 하지 말고, 배열로 해서 하는 건 어떨까?
		그럼 rotate 연산에서 반복이 한 번 줄어드는데...
		그리고 ShiftRow 때는 연산 개수만큼 + 때린 다음 mod 해버리는 거지.
		해보니까, idx 배열이랑 deque 배열 연결시키는 부분이 빡세네...

class Solution {
    static Deque<Integer> Idx;
	static Deque<Integer>[] Row;
	
	public int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = {};
        
        Idx = new ArrayDeque<>(rc.length);
        Row = new ArrayDeque[rc.length];
        for (int i = 0; i < rc.length; i++) {
        	Idx.offerLast(i);
        	Row[i] = new ArrayDeque<>();
        }
        
        for (int i = 0; i < rc.length; i++)
        	for (int j = 0; j < rc[i].length; j++)
        		Row[i].offerLast(rc[i][j]);
        
        for (String operation : operations) {
        	if (operation.equals("ShiftRow"))
        		Idx.offerFirst(Idx.pollLast());
        	else {
        		rotate(Idx.iterator(), false);
        		rotate(Idx.descendingIterator(), true);
        	}
        }
        
        answer = new int[rc.length][];
        for (int i = 0; i < rc.length; i++)
        	answer[i] = new int[rc[i].length];
        Iterator<Integer> iter = Idx.iterator();
        for (int i = 0; i < rc.length; i++) {
        	int idx = iter.next();
        	for (int j = 0; j < rc[i].length; j++) {
        		answer[i][j] = Row[idx].pollFirst(); 
        	}
        }

        return answer;
    }
	
	static void rotate(Iterator<Integer> iter, boolean reversed) {
        int i, data = 0;
        if (iter.hasNext()) {
            i = iter.next();
            if (reversed)
            	data = Row[i].pollFirst();
            else
            	data = Row[i].pollLast();
        }
		while (iter.hasNext()) {
            i = iter.next();
            if (!iter.hasNext()) {
            	if (reversed)
            		Row[i].offerFirst(data);
            	else
            		Row[i].offerLast(data);
            	break;
            }
            int temp;
            if (reversed) {
            	temp = Row[i].pollFirst();
            	Row[i].offerFirst(data);
            } else {
            	temp = Row[i].pollLast();
            	Row[i].offerLast(data);
            }
            data = temp;
        }
	}
}		

		정확성: 25(만점) / 효율성 41.7 / 합계: 66.7
		to, to, 44, to, 57, to, 62, 40, 63
		확실히 좀 더 빨리 하는 거 같긴 해??
		 - Rotate 한 번에 하도록 최적화

class Solution {
    static Deque<Integer> Idx;
	static Deque<Integer>[] Row;
	
	public int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = {};
        
        Idx = new ArrayDeque<>(rc.length);
        Row = new ArrayDeque[rc.length];
        for (int i = 0; i < rc.length; i++) {
        	Idx.offerLast(i);
        	Row[i] = new ArrayDeque<>();
        }
        
        for (int i = 0; i < rc.length; i++)
        	for (int j = 0; j < rc[i].length; j++)
        		Row[i].offerLast(rc[i][j]);
        
        for (String operation : operations) {
        	if (operation.equals("ShiftRow"))
        		Idx.offerFirst(Idx.pollLast());
        	else {
        		rotate(Idx.iterator());
        	}
        }
        
        answer = new int[rc.length][];
        for (int i = 0; i < rc.length; i++)
        	answer[i] = new int[rc[i].length];
        Iterator<Integer> iter = Idx.iterator();
        for (int i = 0; i < rc.length; i++) {
        	int idx = iter.next();
        	for (int j = 0; j < rc[i].length; j++) {
        		answer[i][j] = Row[idx].pollFirst(); 
        	}
        }

        return answer;
    }
	
	static void rotate(Iterator<Integer> iter) {
		int[] seq = new int[Row.length];
		int i = 0;
		while (iter.hasNext()) {
			seq[i] = iter.next();
			i++;
		}
		
		int data1 = Row[seq[0]].pollLast();
		int data2 = Row[seq[Row.length - 1]].pollFirst();
		for (i = 1; i < Row.length - 1; i++) {
			int temp = data1;
			data1 = Row[seq[i]].pollLast();
			Row[seq[i]].offerLast(temp);
			temp = data2;
			data2 = Row[seq[Row.length - 1 - i]].pollFirst();
			Row[seq[Row.length - 1 - i]].offerFirst(temp);
		}
		Row[seq[Row.length - 1]].offerLast(data1);
		Row[seq[0]].offerFirst(data2);
	}
}

		정확성: 25(만점) / 효율성 41.7 / 합계: 66.7
		to, to, 33, to, 77, to, 48, 35, 77
		확실히 좀 더 빨리 하는 거 같긴 해??
		 - ShiftRow 여러 번일 경우 최적화
		 - answer[i] = Row[idx].stream().mapToInt(Integer::intValue).toArray();
		 - 이렇게 할당해봤는데, 오히려 더 느리네...?
		 
		 
		 ㅇ	ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ	ㅇ
		 ㅇ	ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ	ㅇ
		 ㅇ	ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ	ㅇ
		 ㅇ	ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ	ㅇ
		 ㅇ	ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ	ㅇ
		 ㅇ	ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ	ㅇ
		 
		 o -> 양쪽에 LinkedList 두 개.
		 ㅁ -> 행마다 Deque 하나씩
 				*/

class Solution {

	static int N, M;
	static Deque<Integer> Idx;
	static Deque<Integer>[] Row;
	static LinkedList<Integer> Col1, Col2;

	public static int[][] solution(int[][] rc, String[] operations) {

		N = rc.length;
		M = rc[0].length;
		Idx = new ArrayDeque<>();
		Row = new ArrayDeque[N];
		for (int i = 0; i < N; i++) {
			Row[i] = new ArrayDeque<>();
			for (int j = 1; j < M - 1; j++)
				Row[i].addLast(rc[i][j]);
			Idx.addLast(i);
		}
		Col1 = new LinkedList<>();
		Col2 = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			Col1.addLast(rc[i][0]);
			Col2.addLast(rc[i][M - 1]);
		}

		for (String operation : operations) {
			if (operation.equals("ShiftRow")) {
				shift();
			} else {
				rotate();
			}
		}
		return res(rc);
	}

	static void shift() {

		Idx.addFirst(Idx.pollLast());
		Col1.addFirst(Col1.pollLast());
		Col2.addFirst(Col2.pollLast());
	}

	static void rotate() {

		int first = Idx.peekFirst();
		int last = Idx.peekLast();

		if (M == 2) {
			Col2.addFirst(Col1.pollFirst());
			Col1.addLast(Col2.pollLast());
			return;
		}
		
		Col2.addFirst(Row[first].pollLast());
		Row[last].addLast(Col2.pollLast());
		Col1.addLast(Row[last].pollFirst());
		Row[first].addFirst(Col1.pollFirst());
	}

	static int[][] res(int[][] rc) {

		int[][] res;

		res = new int[N][];
		for (int i = 0; i < N; i++)
			res[i] = new int[M];

		Iterator<Integer> iter = Idx.iterator();
		int i = 0;
		while (iter.hasNext()) {
			int idx = iter.next();
			res[i][0] = Col1.pollFirst();
			for (int j = 1; j < M - 1; j++)
				res[i][j] = Row[idx].pollFirst();
			res[i][M - 1] = Col2.pollFirst();
			i++;
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] rc = {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }
				};
		String[] operations1 = { "ShiftRow"};
		String[] operations2 = { "ShiftRow", "Rotate"};
		show(solution(rc, operations1));
		show(solution(rc, operations2));
		
	}
	
	static void show(int[][] ret) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%5d ", ret[i][j]);
			}
			System.out.println();
		}
		System.out.println("=====================");
	}
}