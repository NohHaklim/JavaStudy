package Level_1;

/*
 * 		@ 평균 구하기
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/12944
 */

class PRG12944 {
	public double solution(int[] arr) {
        double answer = 0;
        
        for (int num : arr) {
            answer += num;
        }
        return answer / arr.length;
    }
}

//		
//		return (int) Arrays.stream(array).average().orElse(0);
//		Arrays.stream(배열)
//							.average()
//							.sum() 등등...
//		