package com.ds.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderOfBinaryTree {
	
	public static void printVerticalOrder(Node root){
		Map<Integer,List<Integer>> distanceMap=new TreeMap<Integer,List<Integer>>();
		Queue<QueueItem> queue=new LinkedList<QueueItem>();
		queue.add(new QueueItem(root,0));
		System.out.println("Vertical Order is:");
		while(!queue.isEmpty()){
			QueueItem item = queue.poll();
			if(!distanceMap.keySet().contains(item.hd)){
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(item.node.data);
				distanceMap.put(item.hd,list);
				//System.out.print(item.node.data+" ");
			}
			else{
				distanceMap.get(item.hd).add(item.node.data);
			}
			if(item.node.left!=null)
				queue.add(new QueueItem(item.node.left,item.hd-1));
			if(item.node.right!=null)
				queue.add(new QueueItem(item.node.right,item.hd+1));
		}
		for(Map.Entry<Integer,List<Integer>> entry:distanceMap.entrySet()){
			System.out.print(entry.getKey()+":");
			for(Integer i:entry.getValue()){
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
	/*	Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);*/
		
		Node root=new Node(1);
		root.right=new Node(3);
		root.left=new Node(2);
		root.left.right=new Node(4);
		root.left.right.right=new Node(5);
		root.left.right.right.right=new Node(6);
		printVerticalOrder(root);

	}

}
