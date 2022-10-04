package Level_2;

import java.util.Stack;

public class PRG12909 {
	boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
        	if (ch == '(') {
        		stack.push(ch);
        	} else {
        		if (stack.isEmpty() || stack.pop() != '(') {
        			return false;
        		}
        	}
        }
        if (!stack.isEmpty()) {
        	return false;
        }
        return true;
    }
}
