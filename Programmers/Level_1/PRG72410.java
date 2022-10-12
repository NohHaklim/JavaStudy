package Level_1;

/*
 * 		@ 신규 아이디 추천
 *		@ https://school.programmers.co.kr/learn/courses/30/lessons/72410


	문제::: a.#.a 같은 경우 a.a가 돼야 하는데, 아래처럼 하면 a..a가 된다.
    // 2. 알파벳 소문자, 숫자, -, _, . 제외한 모든 문자 제거
    int i = 0;
    while (i < new_id.length()) {
    	char ch = new_id.charAt(i);
    	if (('a' <= ch && ch <= 'z') || ('0' <= ch && ch <= '9')
    			|| ch == '-' || ch == '_')
    		sb.append(ch);

    	// 3. 연속된 . 제거
    	if (ch == '.') {
    		sb.append(ch);
    		while (i < new_id.length() && ch == '.')
        		i++;
    	} else
    		i++;
    }
}
*/

public class PRG72410 {
	public String solution(String new_id) {

		StringBuilder sb = new StringBuilder();

		// 1. 대문자 -> 소문자
		new_id = new_id.toLowerCase();

		// 2. 알파벳 소문자, 숫자, -, _, . 제외한 모든 문자 제거
		int i = 0;
		while (i < new_id.length()) {
			char ch = new_id.charAt(i);
			if (('a' <= ch && ch <= 'z') || ('0' <= ch && ch <= '9') || ch == '-' || ch == '_' || ch == '.')
				sb.append(ch);
			i++;
		}

		// 3. 연속된 . 제거
		new_id = sb.toString();
		while (new_id.contains(".."))
			new_id = new_id.replace("..", ".");

		// 4. .이 처음이나 끝에 위치한다면 제거
		if (new_id.startsWith("."))
			new_id = new_id.substring(1);
		if (new_id.endsWith("."))
			new_id = new_id.substring(0, new_id.length() - 1);

		// 5. 빈 문자열이라면 a 대입
		if (new_id.length() == 0)
			new_id = "a";

		// 6. 15자 까지만 저장, .이 있으면 제거
		if (new_id.length() > 15)
			new_id = new_id.substring(0, 15);
		if (new_id.endsWith("."))
			new_id = new_id.substring(0, new_id.length() - 1);

		// 7. 2자 이하라면 길이가 3이 될 때까지 이어 붙이기
		StringBuilder ret = new StringBuilder();
		ret.append(new_id);
		char last = new_id.charAt(new_id.length() - 1);
		while (ret.length() <= 2)
			ret.append(last);

		return ret.toString();
	}
}