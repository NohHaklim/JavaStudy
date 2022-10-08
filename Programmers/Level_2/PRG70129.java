package Level_2;

public class PRG70129 {
	public int[] solution(String s) {
		int[] answer = new int[2];
        int temp;
        while( !s.equals("1") ) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);
            //System.out.println("s : " + s ); 
            answer[0]++;
            answer[1] -= temp;
        }
        return answer; 
		
	}
//
//		int numberRemoved = 0;
//		int numberConverted = 0;
//
//		while (!s.equals("1")) {
//			int cnt = 0;
//			for (int i = 0; i < s.length(); i++)
//				if (s.charAt(i) == '1')
//					cnt++;
//			numberRemoved += (s.length() - cnt);
//			s = convert(cnt);
//			numberConverted++;
//		}
//
//		return new int[] { numberConverted, numberRemoved };
//	}
//
//	static String convert(int cnt) {
//		if (cnt == 1) {
//			return "1";
//		}
//		
//		return convert(cnt / 2) + Integer.toString(cnt % 2);
//	}
}
