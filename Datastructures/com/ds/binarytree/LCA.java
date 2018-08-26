package com.ds.binarytree;

public class LCA {
	public static boolean f1=false,f2=false;
	public static int lca(Node root,int n1,int n2){
		if(root==null)
			return -1;
		if(root.data==n1){
			f1=true;
			return root.data;
		}
		if(root.data==n2){
			f2=true;
			return root.data;
		}
		int leftlca=lca(root.left,n1,n2);
		int rightlca=lca(root.right,n1,n2);
		if(leftlca!=-1&&rightlca!=-1)
			return root.data;
		return (leftlca!=-1)?leftlca:rightlca;	
	}

	public static void main(String[] args) {
		Node root=new Node(20);
		root.left=new Node(8);
		root.left.left=new Node(4);
		root.left.right=new Node(12);
		root.left.right.left=new Node(10);
		root.left.right.right=new Node(14);
		root.right=new Node(22);
		int lca=lca(root,10,16);
		if(f1&&f2)
			System.out.println("LCA of 10 and 16:"+lca);
		else
			System.out.println("Keys are not found");
	}

}
