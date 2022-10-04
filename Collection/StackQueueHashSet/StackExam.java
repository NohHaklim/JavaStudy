package StackQueueHashSet;

import java.util.ArrayList;

class MyStack {
	
	private ArrayList<String> arrayStack = new ArrayList<>();
	private int size = 0;
	
	public void push(String data) {
		arrayStack.add(data);
		size++;
	}
	
	public String pop() {
		if (size != 0) {
			size--;
			return arrayStack.remove(size);
		} else {
			System.out.println("스택이 비었습니다.");
			return null;
		}
	}
	
	public int size() {
		return size;
	}
}

public class StackExam {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
