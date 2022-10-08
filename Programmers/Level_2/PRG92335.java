package Level_2;

/*
 * 		@ k진수에서 소수 개수 구하기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */

public class PRG92335 {
	public int solution(int n, int k) {
        int answer = 0;
        
//      양의 정수 n -> k진수 변환 후 0을 기준으로 split
        String[] strs = convert(n, k).split("0");

//      각 수의 소수 판별
        for (String str : strs) {
        	if (!str.equals("") && isPrime(str))
        		answer++;
        }
        
        
        return answer;
    }
	
	static String convert(int n, int k) {
		StringBuilder sb = new StringBuilder();
		
		while (n != 0) {
			sb.append(n % k);
			n /= k;
		}
		return sb.reverse().toString();
	}
	
	static boolean isPrime(String str) {
		long nb = Integer.parseInt(str);

		long i = 2L;
		if (nb < i)
			return false;
		while (i * i <= nb) {
			if ((nb % i) == 0)
				return false;
			i++;
		}
		return true;
	}
}
