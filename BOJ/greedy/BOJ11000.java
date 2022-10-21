package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 		@ 강의실 배정
 *		@ https://www.acmicpc.net/problem/11000
 *		@
 *
 *	* 실패한 배정 코드. 강의실 수가 200,000개라서 시간초과 발생.
 *	* 게다가 수정 전 코드에서는 할당된 강의 종료 시간을 최신화하지 않아서 계속 틀렸었음
 	Assigned = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			Room newRoom = Classroom.get(i);
			boolean flag = false;
			for (int j = 0; j < Assigned.size(); j++) {
				Room AssignedRoom = Classroom.get(Assigned.get(j));
				if (AssignedRoom.e <= newRoom.s) {
					Assigned.set(j, i);
					flag = true;
					break;
				} else {
					continue;
				}
			}
			if (!flag)
				Assigned.add(i);
		}
 * 
 * 
 * 
 */

public class BOJ11000 {

	static int N;
	static Lecture[] Lectures;
	static PriorityQueue<Integer> PQ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1. start 타임이 작은 순으로 정렬
		N = Integer.parseInt(st.nextToken());
		Lectures = new Lecture[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			Lectures[i] = new Lecture(s, e);
		}
		Arrays.sort(Lectures, (a, b) -> ((a.s == b.s) ? (a.e - b.e) : (a.s - b.s)));
		
		// 2. 강의실 배정
		PQ = new PriorityQueue<>();
		PQ.offer(Lectures[0].e);
		
		for (int i = 1; i < N; i++) {
			if (PQ.peek() <= Lectures[i].s) {
				PQ.poll();
			}
			PQ.offer(Lectures[i].e);
		}
		System.out.println(PQ.size());
	}
}

class Lecture {
	int s, e;
	
	Lecture(int s, int e) {
		this.s = s;
		this.e = e;
	}
}