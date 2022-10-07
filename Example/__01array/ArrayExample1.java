package __01array;

import java.util.*;

public class ArrayExample1 {
	
	static int N;
	static int[] Score;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Score = new int[N];
		
		for (int i = 0; i < N; i++) {
			Score[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Score[i] + " ");
		}
		
		sc.close();
	}
}
