package StackQueueHashSet;

import java.util.HashSet;

public class HashSetExam {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<>();
		
		boolean b1 = set.add("a");
		set.add("b");
		set.add("c");
		System.out.println(set);
		
//		중복이 안됨.
		boolean b2 = set.add("a");
		System.out.println(set);
		System.out.println(b1 + ", " + b2);
	}

}
