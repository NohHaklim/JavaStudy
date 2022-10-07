package __array;

import java.util.*;

public class ArrayExample2 {
	
	static int Row, Col;
	static int[][] Board;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Row = sc.nextInt();
		Col = sc.nextInt();
		Board = new int[Row][Col];
		
		for (int i = 0; i < Row; i++) {
			for (int j = 0; j < Col; j++) {
				Board[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < Row; i++) {
			for (int j = 0; j < Col; j++) {
				System.out.println(Board[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
