package _03;

import java.util.Scanner;

/*
 * 		@ 가장 많이 출현한 수를 출력하시오.
 *		입력: 0 ~ 9의 숫자가 랜덤하게 10번
 *		출력: 가장 많이 등장한 숫자 출력
 *		예외: 최빈수가 여러 개일 경우 처리 방법이 안 나와있어서 가장 마지막에 출현한 최빈수로 출력했음.
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		int maxNum = -1;
		int num = -1;
		int[] inNum = new int[10];
		int[] mode = new int[10];
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			inNum[i] = sc.nextInt();
		}
		sc.close();
		
		for (int i = 0; i < 10; i++) {
			mode[inNum[i]]++;
			if (maxNum < mode[inNum[i]]) {
				maxNum = mode[inNum[i]];
				num = inNum[i];
			}
		}
		System.out.println(num);
	}
}
