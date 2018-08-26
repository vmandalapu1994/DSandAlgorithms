package com.ds.bst;

public class BinarySearchTree {
	Node root;
	public int size=0;
	public static int prev,next=Integer.MIN_VALUE;

	public void insert(int key){
		Node n=new Node();
		n.key=key;
		if(root==null){
			root=n;
			size++;
			return ;
		}
		else
		{
			Node position=root;
			while(true){
				if(n.isGreater(position)){
					if(position.right==null){
						position.right=n;
						size++;
						return ;
					}
					position=position.right;
				}
				else
				{
					if(position.left==null){
						position.left=n;
						size++;
						return ;
					}
					position=position.left;	
				}
			}
		}
		
	}
	
	public Node delete (Node root,int key){
		if(key>root.key)
			root.right=delete(root.right,key);
		else if(key<root.key)
			root.left=delete(root.left,key);
		else{
			if(root.left==null || root.right==null){
				root=root.left!=null?root.left:root.right;
			}else{
				int successor=inOrderSuccessor(root, key);
				root.key=successor;
				root.right=delete(root.right,successor);
			}
		}
		return root;
	}
	public Node search(Node root,int key){
		if(root==null)
			return null;
		else
		{
			if(root.key==key)
				return root;
			else {
				if(root.key<key){
					return search(root.right,key);
				}
				else
					return search(root.left,key);
			}
		}
	}
	
	public Node minimum(Node root){
		if(root==null)
			return null;
		else
		{
			while(root.left!=null){
				root=root.left;
			}
			return root;
		}
		
	}
	public Node maximum(Node root){
		if(root==null)
			return null;
		else
		{
			while(root.right!=null){
				root=root.right;
			}
			return root;
		}
		
	}
	public void inorder(Node root){
		if(root==null)
			return ;
		else
		{
			inorder(root.left);
			System.out.print(root.key+" ");
			inorder(root.right);
		}
		
	}
	public void postorder(Node root){
		if(root==null)
			return ;
		else
		{
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.key+" ");
		}
		
	}
	public void preorder(Node root){
		if(root==null)
			return ;
		else
		{
			System.out.print(root.key+" ");
			preorder(root.left);
			preorder(root.right);
		}
		
	}
	public int inOrderSuccessor(Node root,int key){
		Node node = search(root,key);
		if(node==null)
			return -1;
		if(node.right!=null)
			return minimum(node.right).key;
		int succ=-1;
		while(root!=null){
			if(root.key>key)
			{
				succ=root.key;
				root=root.left;
			}
			else if(root.key<key){
				root=root.right;
			}
			else
				break;	
		}
		return succ;	
	}
	
	public int inOrderPredecessor(Node root,int key){
		Node node = search(root,key);
		if(node==null)
			return -1;
		if(node.left!=null)
			return maximum(node.left).key;
		int succ=-1;
		while(root!=null){
			if(root.key<key)
			{
				succ=root.key;
				root=root.right;
			}
			else if(root.key>key){
				root=root.left;
			}
			else
				break;	
		}
		return succ;	
	}
	
	public Node LCA(Node root,int n1,int n2){
		while(root!=null){
			if(root.key>n1&&root.key>n2)
				root=root.left;
			else if(root.key<n1&&root.key<n2)
				root=root.right;
			else
				return root;
		}
		return null;	
	}
	
	public static int minValue(Node root){
		while(root.left!=null){
			root=root.left;
		}
		return root.key;
	}
	public static int maxValue(Node root){
		
		while(root.right!=null){
			root=root.right;
		}
		return root.key;
	}
	public static boolean isBST(Node root){
		if(root==null)
			return true;
		if(root.left!=null){
			if(maxValue(root.left)>root.key)
				return false;
		}
		if(root.right!=null){
			if(minValue(root.right)<root.key)
				return false;
		}
		
		return isBST(root.left)&&isBST(root.right);
	}
	public static boolean isBSTUtil(Node root,int min,int max){
		if(root==null)
			return true;
		if(root.key<min||root.key>max)
			return false;
		return isBSTUtil(root.left,min,root.key-1)&&isBSTUtil(root.right,root.key+1,max);
	}
	
	public static boolean isBSTUtil1(Node root){
		if(root==null)
			return true;
		if(!isBSTUtil1(root.left))
			return false;
		prev=next;
		next=root.key;
		if(next<prev)
			return false;
		if(!isBSTUtil1(root.right))
			return false;
		return true;
		
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst=new BinarySearchTree();
		bst.insert(10);
		bst.insert(9);
		bst.insert(23);
		bst.insert(45);
		bst.insert(12);
		bst.insert(18);
		bst.insert(55);
		bst.inorder(bst.root);
		System.out.println();
		bst.delete(bst.root,23);
		bst.inorder(bst.root);
		System.out.println();
		bst.delete(bst.root,10);
		bst.inorder(bst.root);
		
		
		//System.out.println("Least Common Ancestor of 12 and 55 is:"+bst.LCA(bst.root,12,55).key);
/*		bst.preorder(bst.root);
		System.out.println();
		bst.inorder(bst.root);
		System.out.println();          
		bst.postorder(bst.root);
		System.out.println();
		Node result = bst.search(bst.root,23);
		System.out.println(result.key+" left child:"+result.left.key+" right child:"+result.right.key);
		System.out.println("Maximum value:"+bst.maximum(bst.root).key);
		System.out.println("Minimum value:"+bst.minimum(bst.root).key);
		System.out.println("Inorder successor of 18:"+bst.inOrderSuccessor(bst.root,18));
		System.out.println("Inorder predecessor of 12:"+bst.inOrderPredecessor(bst.root,12));
		bst.delete(bst.root,18);
		bst.inorder(bst.root);
		System.out.println();
		bst.delete(bst.root,23);
		bst.inorder(bst.root);
		System.out.println();
		bst.delete(bst.root,45);
		bst.inorder(bst.root);
		System.out.println();*/
		
		
/*		to check given binary tree is BST or not
 * 		Node root=new Node();
		root.key=20;
		root.left=new Node();
		root.left.key=15;
		root.left.left=new Node();
		root.left.left.key=12;
		root.left.right=new Node();
		root.left.right.key=18;
		root.right=new Node();
		root.right.key=25;
		root.right.left=new Node();
		root.right.left.key=22;
		root.right.right=new Node();
		root.right.right.key=30;
		//System.out.println(isBST(root));
		//System.out.println(isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
		System.out.println(isBSTUtil1(root));*/
	}

}
class Node{
	int key;
	Node left;
	Node right;
	Node(){
		
	}
	Node(int key){
		this.key=key;
	}
	public boolean isGreater(Node n){
		return this.key>n.key?true:false;	
	}
}
