package Level_1;

/*
 * 		@ 약수의 합
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12928 
 */

class PRG12928 {	// 최악 케이스: (0.09ms, 72.9mb), (0.01ms, 88.2mb)
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }
}

class PRG12928_2 {	// 최적화 시도
    public int solution(int n) {
        int halfOfN = n >> 1;
        int answer = 0;
        boolean[] flag = new boolean[1501];

        if (n <= 1) {
            return n;
        } // 1
        answer += 1 + n;
        for (int i = 2; i <= halfOfN; i++) { // 0
            if (flag[i]) {
                break;
            }
            if (((n % i) & 1) == 0) {
                int tmp = (n / i);
                answer += i;
                if (i == tmp) {
                    return answer;
                } // 2
                answer += tmp;
                flag[i] = flag[tmp] = true;
            }
        }
        return answer;
    }
}

//		놓쳤던 부분:
//			0. n 바로 이전의 제곱수를 만드는 수까지만 루프를 돌리면 됨.
//			1. 0이상의 수가 입력으로 들어옴.
//			2. 특정 수의 제곱인 경우

class PRG12928_3 {	// 최악 케이스: (0.04ms, 75.5mb), (0.02ms, 78.3mb)
    public int solution(int n) {
        int answer = 0;
        boolean[] flag = new boolean[1501];

        if (n <= 1) {
            return n;
        }
        answer += 1 + n;
        for (int i = 2; i * i <= n; i++) {
            if (flag[i]) {
                break;
            }
            if ((n % i) == 0) {
                int tmp = (n / i);
                answer += i;
                if (i == tmp) {
                    return answer;
                }
                answer += tmp;
                flag[i] = flag[tmp] = true;
            }
        }
        return answer;
    }
}