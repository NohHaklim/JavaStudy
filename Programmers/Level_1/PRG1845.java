package Level_1;

import java.util.Arrays;

public class PRG1845 {
	public int solution(int[] nums) {
        int num = nums.length / 2;
        int category = (int)Arrays.stream(nums).distinct().count();
        
        return ((num < category) ? (num) : (category));
    }
}

//		return Arrays.stream(nums)
//		        .boxed()
//		        .collect(Collectors.collectingAndThen(Collectors.toSet(),
//		                phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
//
//		HashSet은 중복을 없애서 저장