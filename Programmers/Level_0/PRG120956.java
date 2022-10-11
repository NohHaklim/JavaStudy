package Level_0;

/*
 * 		@ 옹알이
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/120956
 */

public class PRG120956 {

	int N = 4;
	String[] strs = { "aya", "ye", "woo", "ma" };
	int[] nb = { 3, 2, 3, 2 };

	public int solution(String[] babbling) {
        int answer = 0;
        
        for (String b : babbling) {
            int preB = -1;
			while (b.length() != 0) {
				boolean p = false;
				for (int i = 0; i < N; i++) {
                    if (preB == i)
                        continue;
					if (b.length() >= nb[i] && 
                        b.substring(0, nb[i]).equals(strs[i])) {
                        if (b.length() >= nb[i])
						    b = b.substring(nb[i]);
                        else
                            b = "";
						p = true;
                        preB = i;
						break;
					}
				}
				if (p == false)
					break;
			}
			if (b.length() == 0)
				answer++;
		}
        
        return answer;
    }
}

/*
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String s : babbling) {
            if (s.contains("ayaaya") || s.contains("yeye") || s.contains("woowoo") || s.contains("mama")) {
                continue;
            }
            String result = s.replaceAll("aya", "").replaceAll("ye", "").replaceAll("woo", "").replaceAll("ma", "");

            if (result.length() == 0) {
                answer ++;
            }
        }
        return answer;
    }
}

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i=0; i<babbling.length; i++){
            if(babbling[i].matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")){
                answer++;
            }
        }
        return answer;
    }
}
*/
