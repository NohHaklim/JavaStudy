package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10798 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] strs = new char[5][15];
		
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < str.length(); j++) {
				strs[i][j] = str.charAt(j);
			}
		}
		
		for (int j = 0; j < 15; j++) {
			for (int i = 0; i < 5; i++) {
				if (strs[i][j] == '\0') {
					continue;
				}
				System.out.print(strs[i][j]);
			}
		}
	}
}
