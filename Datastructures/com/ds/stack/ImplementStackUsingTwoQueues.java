package com.ds.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingTwoQueues {
	
	Queue<Integer> queue1=new  LinkedList<Integer>();
	Queue<Integer> queue2=new  LinkedList<Integer>();
	
	public void push(int ele){
		queue2.add(ele);
		while(!queue1.isEmpty()){
			queue2.add(queue1.poll());
		}
		Queue<Integer> temp=queue1;
		queue1=queue2;
		queue2=temp;
	}
	
	
	/*public void push(int ele){
		queue1.add(ele);
	}*/
	
	public int pop(){
		return queue1.poll();
	}
	
	/*public int pop(){
		while(queue1.size()!=1){
			queue2.add(queue1.poll());
		}
		Queue<Integer> temp=queue1;
		queue1=queue2;
		queue2=temp;
		return queue2.poll();	
	}*/

	public static void main(String[] args) {
		ImplementStackUsingTwoQueues stack = new ImplementStackUsingTwoQueues();
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
