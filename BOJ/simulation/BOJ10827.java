package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/*
 * 		@ a^b
 *		@ https://www.acmicpc.net/problem/10827
 */

public class BOJ10827 {

	static String A;
	static int B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = st.nextToken();
		B = Integer.parseInt(st.nextToken());
		
		BigDecimal nb = new BigDecimal(A);
		BigDecimal ret = new BigDecimal(1);
		
		while (B != 0) {
			if ((B & 1) == 1) {
				ret = ret.multiply(nb);
			}
			nb = nb.multiply(nb);
			B >>= 1;
		}
		
		System.out.println(ret.toPlainString());
	}
}