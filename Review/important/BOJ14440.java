package important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		@ 정수 수열
 *		@ https://www.acmicpc.net/problem/14440
 *		@ 행렬 거듭제곱을 이용한 선형 점화식의 DP 풀이
 */

public class BOJ14440 {

	static void putNb(int n) {
		StringBuilder sb = new StringBuilder();

		if (n < 10)
			sb.append("0").append(n);
		else
			sb.append(n / 10).append(n % 10);
		System.out.println(sb.toString());
	}

	static class Matrix {
		int[][] m = new int[2][2];

		Matrix(int a, int b, int c, int d) {
			this.m[0][0] = a;
			this.m[0][1] = b;
			this.m[1][0] = c;
			this.m[1][1] = d;
		}

		Matrix multiply(Matrix o) {
			int a = this.m[0][0] * o.m[0][0] + this.m[0][1] * o.m[1][0];
			int b = this.m[0][0] * o.m[0][1] + this.m[0][1] * o.m[1][1];
			int c = this.m[1][0] * o.m[0][0] + this.m[1][1] * o.m[1][0];
			int d = this.m[1][0] * o.m[0][1] + this.m[1][1] * o.m[1][1];

			return new Matrix(a % 100, b % 100, c % 100, d % 100);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x, y, a, b, n;
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		Matrix temp = new Matrix(x, y, 1, 0);
		Matrix ans = new Matrix(1, 0, 0, 1);
		if (n == 0)
			putNb(a);
		else if (n == 1)
			putNb(b);
		else {
			n--;
			while (n > 0) {
				if ((n & 1) == 1)
					ans = ans.multiply(temp);
				temp = temp.multiply(temp);
				n >>= 1;
			}
			putNb((ans.m[0][0] * b + ans.m[0][1] * a) % 100);
		}
	}
}