package com.ds.binarytree;

public class BTDiameter {
	
	public static int diameter(Node node){
		if(node==null)
			return 0;
		int leftDiameter=diameter(node.left);
		int rightDiameter=diameter(node.right);
		return max(1+height(node.left)+height(node.right),leftDiameter,rightDiameter);	
	}
	
	public static int max(int a,int b,int c){
		return a>b?a>c?a:c:b>c?b:c;
	}
	
	public static int height(Node node){
		if(node==null)
			return 0;
		return 1+Math.max(height(node.left),height(node.right));
	}
	
	public static int diameter(Node node,Height h){
		if(node==null){
			h.h=0;
			return 0;
		}
		Height lh=new BTDiameter().new Height();
		Height rh=new BTDiameter().new Height();
		lh.h++;
		rh.h++;;
		int leftDiameter=diameter(node.left,lh);
		int rightDiameter=diameter(node.right,rh);
		h.h=Math.max(lh.h,rh.h)+1;
		return max(1+lh.h+rh.h,leftDiameter,rightDiameter);
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
		System.out.println("Diameter of binary tree is:"+diameter(root));
		System.out.println("Diameter of binary tree is:"+diameter(root,new BTDiameter().new Height()));
	}
	
	public class Height{
		int h;
	}

}
