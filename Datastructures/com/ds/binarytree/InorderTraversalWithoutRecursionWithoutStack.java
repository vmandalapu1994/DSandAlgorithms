package com.ds.binarytree;

public class InorderTraversalWithoutRecursionWithoutStack {
	
	public static void printInorderTraversal(Node root){
		Node current=root;
		
		while(current!=null){
			if(current.left==null){
				System.out.print(current.data+" ");
				current=current.right;
			}else{
				Node pre=current.left;
				while(pre.right!=null && pre.right!=current){
					pre=pre.right;
				}
				if(pre.right==null){
					pre.right=current;
					current=current.left;
				}
				else{
					pre.right=null;
					System.out.print(current.data+" ");
					current=current.right;
				}
			}
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
		System.out.println("Inorder traversal without recursion and stack is:");
		printInorderTraversal(root);
	}

}
