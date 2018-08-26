package com.ds.binarytree;

public class SumOfLeftLeaves {
	public static int sum=0;
	
	public static void sumOfLeftLeaves(Node root){
		if(root==null)
			return;
		if(isLeaf(root.left))
			sum+=root.left.data;
		else
			sumOfLeftLeaves(root.left);
		sumOfLeftLeaves(root.right);	
	}
	
	public static boolean isLeaf(Node node){
		if(node==null)
			return false;
		return node.left==null && node.right==null;
	}

	public static void main(String[] args) {
		Node root=new Node(10);
		root.left=new Node(20);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.right.left.left=new Node(8);
		sumOfLeftLeaves(root);
		System.out.println("Sum Of Left Leaves:"+sum);

	}

}
