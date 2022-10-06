package Level_2;

/*
 * 		@ 모음사전
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/84512
 *		@ 
 */

public class PRG84512 {

	public int solution(String word) {

        int answer = word.length();
        
        String str = "AEIOU";
        int[] x = {781, 156, 31, 6, 1};
        
        for (int i=0; i<word.length(); i++) {
            int idx = str.indexOf(word.charAt(i));
            answer += x[i] * idx;
        }
        
        return answer;
    }
}
