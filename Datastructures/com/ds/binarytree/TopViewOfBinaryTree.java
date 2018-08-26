package com.ds.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class TopViewOfBinaryTree {
	
	public static void printTopView(Node root){
		Map<Integer,Integer> distanceMap=new TreeMap<Integer,Integer>();
		Queue<QueueItem> queue=new LinkedList<QueueItem>();
		queue.add(new QueueItem(root,0));
		System.out.println("Top View is:");
		while(!queue.isEmpty()){
			QueueItem item = queue.poll();
			if(!distanceMap.keySet().contains(item.hd)){
				distanceMap.put(item.hd,item.node.data);
				//System.out.print(item.node.data+" ");
			}
			if(item.node.left!=null)
				queue.add(new QueueItem(item.node.left,item.hd-1));
			if(item.node.right!=null)
				queue.add(new QueueItem(item.node.right,item.hd+1));
		}
		for(Map.Entry<Integer,Integer> entry:distanceMap.entrySet()){
			System.out.print(entry.getValue()+" ");
		}
			
	}

	public static void main(String[] args) {
	/*	Node root=new Node(1);
		root.right=new Node(3);
		root.left=new Node(2);
		root.left.right=new Node(4);
		root.left.right.right=new Node(5);
		root.left.right.right.right=new Node(6);*/
		
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		printTopView(root);
		

	}


}

class QueueItem{
	Node node;
	int hd;
	QueueItem(Node n,int d){
		this.node=n;
		this.hd=d;
	}
}
