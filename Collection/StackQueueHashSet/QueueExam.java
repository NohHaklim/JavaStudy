package StackQueueHashSet;

import java.util.ArrayList;

class MyQueue {
	private ArrayList<String> arrayQueue = new ArrayList<>();
	private int size = 0;
	
	public void enQueue(String data) {
		arrayQueue.add(data);
		size++;
	}
	
	public String deQueue() {
		if (size == 0) {
			System.out.println("큐가 비었습니다");
			return null;
		}
		return arrayQueue.remove(0);		// 여기서는 이렇게 했지만, 실제로 느림! 배열을 땡겨야 해서.
	}
	
	public String peek() {
		if (size == 0) {
			System.out.println("큐가 비었습니다");
			return null;
		}
		return arrayQueue.get(0);
	}
}

public class QueueExam {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		
		queue.enQueue("a");
		queue.enQueue("b");
		queue.enQueue("c");

		
		System.out.println(queue.peek());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}

}
