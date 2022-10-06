package Level_2;

/*
 * 		@ 카펫
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/42842
 *		@ yellow의 약수를 구해서, +2씩 더한 값을 곱해서 나온 값 - yellow의 수 == brown인지 체크
 */

public class PRG42842 {
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 1; i <= yellow; i++) {
        	if (yellow % i != 0)
        		continue;
        	int h = i + 2;
        	int w = (yellow / i) + 2;
        	if (w * h - yellow == brown) {
        		answer[0] = w;
        		answer[1] = h;
        		break;
        	}
        }
        
        return answer;
    }
}
