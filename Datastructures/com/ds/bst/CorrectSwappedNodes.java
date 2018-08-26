package com.ds.bst;

public class CorrectSwappedNodes {
	static Node prev,first,middle,last;
	public static void correctBST(Node root){
		inOrder(root);
		if(first!=null&&last!=null){
			int temp=first.key;
			first.key=last.key;
			last.key=temp;	
		}
		else if(first!=null && middle!=null){
			int temp=first.key;
			first.key=middle.key;
			middle.key=temp;
		}else{
			System.out.println("No nodes are swapped");
		}
			
	}
	
	public static void inOrder(Node root){
		if(root==null)
			return ;
		inOrder(root.left);
		if(prev!=null && prev.key>root.key){
			if(first==null){
				first=prev;
				middle=root;
			}
			else{
				last=root;	
			}
			
		}else{
			prev=root;
		}
		System.out.print(root.key+" ");
		inOrder(root.right);
	}

	public static void main(String[] args) {
		/*Node root=new Node(10);
		root.left=new Node(5);
		root.left.left=new Node(2);
		root.left.right=new Node(20);
		root.right=new Node(8);*/
		/*Node root = new Node(6);
	    root.left        = new Node(10);
	    root.right       = new Node(2);
	    root.left.left  = new Node(1);
	    root.left.right = new Node(3);
	    root.right.right = new Node(12);
	    root.right.left = new Node(7);*/
		Node root=new Node(10);
		root.left=new Node(2);
		root.right=new Node(20);
		System.out.println("Inorder Traversal After Swapping:");
		correctBST(root);
		System.out.println();
		System.out.println("Inorder Traversal after correcting:");
		inOrder(root);
	}

}
