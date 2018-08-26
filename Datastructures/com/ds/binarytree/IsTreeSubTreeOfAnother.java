package com.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class IsTreeSubTreeOfAnother {
	
	public static Node findNode(Node root,int node){
		if(root==null)
			return null;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node n=queue.poll();
			if(n.data==node)
				return n;
			if(n.left!=null)
				queue.add(n.left);
			if(n.right!=null)
				queue.add(n.right);	
		}
		return null;	
	}
	
	public static boolean isTreesEqual(Node tree1,Node tree2){
		if(tree1==null && tree2==null)
			return true;
		if((tree1==null && tree2!=null)||(tree1!=null && tree2==null))
			return false;
		return (tree1.data==tree2.data && isTreesEqual(tree1.left,tree2.left)&& isTreesEqual(tree1.right,tree2.right));	
	}
	
	public static boolean isSubtree(Node tree1,Node tree2){
		if(tree1==null && tree2==null)
			return true;
		if(tree1==null && tree2!=null)
			return false;
		if(tree1!=null && tree2==null)
			return true;
		Node node = findNode(tree1,tree2.data);
		if(node==null)
			return false;
		return isTreesEqual(node,tree2);	
		
	}

	public static void main(String[] args) {
		Node tree1=new Node(10);
		tree1.left=new Node(2);
		tree1.left.left=new Node(5);
		tree1.left.right=new Node(7);
		tree1.right=new Node(4);
		tree1.right.left=new Node(8);
		tree1.right.right=new Node(10);
		
		Node tree2=new Node(4);
		tree2.left=new Node(8);
		tree2.right=new Node(9);
		if(isSubtree(tree1,tree2))
			System.out.println("Tree2 is subtree of Tree1");
		else
			System.out.println("Tree2 is not subtree of Tree1");
	}

}
