package com.ds.binarytree;

public class MirrorTree {
	
	public static Node mirrorTree(Node root){
		if(root==null)
			return null;
		mirrorTree(root.left);
		mirrorTree(root.right);
		Node temp=root.left;
		root.left=root.right;
		root.right=temp;
		return root;
	}
	
	public static void inOrder(Node root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(3);
		root.right=new Node(2);
		root.right.left=new Node(5);
		root.right.right=new Node(4);
		System.out.println("Inorder traversal of Tree:");
		inOrder(root);
		System.out.println();
		mirrorTree(root);
		System.out.println("Inorder traversal of MirrorTree:");
		inOrder(root);
	}

}


