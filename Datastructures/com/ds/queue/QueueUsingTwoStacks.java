package com.ds.queue;

import java.util.Stack;

public class QueueUsingTwoStacks {
	Stack<Integer> stack1=new Stack<Integer>();
	Stack<Integer> stack2=new Stack<Integer>();
	
	/*public void enQueue(int ele){
		stack1.push(ele);
		
	}*/
	
	
	public void enQueue(int ele){
		
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		
		stack1.push(ele);
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}	
	}
	
	/*public int deQueue(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		
		return stack2.pop();
		
	}*/
	
	public int deQueue(){
		return stack1.pop();
	}

	public static void main(String[] args) {
		
		QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
		queue.enQueue(10);
		queue.enQueue(12);
		queue.enQueue(15);
		queue.enQueue(18);
		System.out.println(queue.deQueue());
		

	}

}
