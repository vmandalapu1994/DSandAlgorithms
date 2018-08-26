package com.ds.binarytree;

public class BTtoDLL {
	
	public Node root,head;
	
	public void BTtoDLL(Node root){
		if(root==null)
			return;
		BTtoDLL(root.right);
		root.right=head;
		if(head!=null)
			head.left=root;
		head=root;
		BTtoDLL(root.left);	
	}
	
	public void traverseDLL(){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.right;
		}
	}

	public static void main(String[] args) {
		BTtoDLL bTtoDLL = new BTtoDLL();
		bTtoDLL.root=new Node(10);
		bTtoDLL.root.left=new Node(12);
		bTtoDLL.root.left.left=new Node(8);
		bTtoDLL.root.left.right=new Node(7);
		bTtoDLL.root.right=new Node(13);
		bTtoDLL.root.right.left=new Node(6);
		bTtoDLL.root.right.right=new Node(15);
		bTtoDLL.BTtoDLL(bTtoDLL.root);
		bTtoDLL.traverseDLL();
	}

}
