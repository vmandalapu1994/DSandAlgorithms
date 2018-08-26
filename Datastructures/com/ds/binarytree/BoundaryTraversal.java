package com.ds.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
	
	public static void printLeafNodes(Node root){
		if(root==null)
			return;
		if(root.left==null && root.right==null)
			System.out.print(root.data+" ");
		printLeafNodes(root.left);
		printLeafNodes(root.right);
		
	}
	
	public static boolean isLeafNode(Node node){
		if(node==null)
			return false;
		return node.left==null && node.right==null?true:false;
		
	}
	
	public static void boundaryTraversal(Node root){
		if(root==null)
			return ;
		Node temp=root;
		while(temp!=null && !isLeafNode(temp)){
			System.out.print(temp.data+" ");
			temp=temp.left;
		}
		printLeafNodes(root);
		List<Integer> values=new ArrayList<Integer>();
		temp=root.right;
		while(temp!=null && !isLeafNode(temp) ){
			values.add(temp.data);
			temp=temp.right;
		}
		for(int i=values.size()-1;i>=0;i--){
			System.out.print(values.get(i)+" ");
		}
			
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
		
		boundaryTraversal(root);
		

	}

}
