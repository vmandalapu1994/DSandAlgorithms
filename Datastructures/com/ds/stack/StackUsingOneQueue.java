package com.ds.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue {
	
	Queue<Integer> queue=new LinkedList<Integer>();
	
	public void push(int ele){
		int s=queue.size();
		queue.add(ele);
		while(s>0){
			queue.add(queue.poll());
			s--;
		}
		
	}
	
	public int pop(){
		return queue.poll();
	}

	public static void main(String[] args) {
		StackUsingOneQueue stack = new StackUsingOneQueue();
		stack.push(10);
		stack.push(12);
		stack.push(16);
		stack.push(23);
		stack.push(25);
		System.out.println(stack.pop());
		stack.push(28);
		stack.push(30);
		System.out.println(stack.pop());

	}

}
