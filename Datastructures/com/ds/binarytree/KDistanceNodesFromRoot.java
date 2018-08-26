package com.ds.binarytree;

public class KDistanceNodesFromRoot {
	
	public static void printKDistNodes(Node root,int dist){
		if(root==null)
			return;
		if(dist==0)
			System.out.println(root.data);
		printKDistNodes(root.left,dist-1);
		printKDistNodes(root.right,dist-1);
	}

	public static void main(String[] args) {
		Node root=new Node(10);
		root.left=new Node(20);
		root.right=new Node(30);
		root.left.left=new Node(25);
		root.left.right=new Node(28);
		root.right.left=new Node(22);
		root.right.right=new Node(34);
		printKDistNodes(root,2);
	
	}

}

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data=data;
		left=null;
		right=null;
	}
}
