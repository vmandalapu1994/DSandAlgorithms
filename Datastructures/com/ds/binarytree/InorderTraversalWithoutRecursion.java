package com.ds.binarytree;

import java.util.Stack;

public class InorderTraversalWithoutRecursion {
	
	public static void printInOrderTraversal(Node root){
		Stack<Node> s=new Stack<Node>();
		Node current=root;
		while(true){
			while(current!=null){
				s.push(current);
				current=current.left;
			}
			if(s.isEmpty())
				break;
			current=s.pop();
			System.out.print(current.data+" ");
			current=current.right;	
		}	
	}

	public static void main(String[] args) {
		Node root=new Node(20);
		root.left=new Node(8);
		root.left.left=new Node(4);
		root.left.right=new Node(12);
		root.left.right.left=new Node(10);
		root.left.right.right=new Node(14);
		root.right=new Node(22);
		System.out.println("Inorder traversal using stack is:");
		printInOrderTraversal(root);

	}

}
