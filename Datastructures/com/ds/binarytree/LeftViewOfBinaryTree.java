package com.ds.binarytree;

public class LeftViewOfBinaryTree {
	public static int max_level=0;
	public static void PrintLeftView(Node root,int level){
		if(root==null)
			return;
		if(level>max_level){
			System.out.print(root.data+" ");
			max_level=level;
		}
		PrintLeftView(root.left,level+1);
		PrintLeftView(root.right,level+1);	
	}

	public static void main(String[] args) {
		Node root=new Node(20);
		root.left=new Node(8);
		root.left.left=new Node(4);
		root.left.right=new Node(12);
		root.left.right.left=new Node(10);
		root.left.right.right=new Node(14);
		root.right=new Node(22);
		System.out.println("Left View is:");
		PrintLeftView(root,1);
	}

}
