package com.ds.queue;

import java.util.Stack;

public class QueueUsingOneStack {
	Stack<Integer> stack1=new Stack<Integer>();
	
	
	public void enQueue(int ele){
		stack1.push(ele);
	}
	
	public int deQueue(){
		if(stack1.isEmpty())
			return -1;
		else if(stack1.size()==1)
			return stack1.pop();
		else{
			int x=stack1.pop();
			int res=deQueue();
			stack1.push(x);
			return res;
		}
		
		
		
	}
	

	public static void main(String[] args) {
		QueueUsingOneStack queue = new QueueUsingOneStack();
		queue.enQueue(11);
		queue.enQueue(12);
		queue.enQueue(15);
		queue.enQueue(18);
		System.out.println(queue.deQueue());

	}

}
