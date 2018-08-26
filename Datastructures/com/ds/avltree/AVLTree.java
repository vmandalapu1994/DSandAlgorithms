package com.ds.avltree;

public class AVLTree {
	AVLNode root;
	
	public int height(AVLNode node){
		if(node==null)
			return 0;
		else
			return node.height;
	}
	
	public int getBalanceFactor(AVLNode node){
		return height(node.left)-height(node.right);
	}
	
	public AVLNode rightRotate(AVLNode z){
		AVLNode y = z.left;
		AVLNode temp = y.right;
		y.right=z;
		z.left=temp;
		z.height=Math.max(height(z.left),height(z.right))+1;
		y.height=Math.max(height(y.left),height(y.right))+1;
		return y;
		
	}
	
	public AVLNode leftRotate(AVLNode z){
		AVLNode y = z.right;
		AVLNode temp = y.left;
		y.left=z;
		z.right=temp;
		z.height=Math.max(height(z.left),height(z.right))+1;
		y.height=Math.max(height(y.left),height(y.right))+1;
		return y;
		
	}
	
	
	public int minValue(AVLNode node){
		AVLNode temp=node;
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp.data;		
	}
	
	public AVLNode delete(AVLNode node,int data){
		if(node==null)
			return null;
		if(node.data<data) {
			node.right=delete(node.right,data);
		}
		else if(node.data>data){
			node.left=delete(node.left,data);
		}
		else{
			if(node.left==null || node.right==null){
				if(node.left==null)
					node=node.right;
				else
					node=node.left;
				//return node;
				
			}
			else{
				node.data=minValue(node.right);
				node.right=delete(node.right,node.data);
			}	
		}
		if(node==null)
			return node;
		node.height=Math.max(height(node.left),height(node.right))+1;
		int bf = getBalanceFactor(node);
		if(bf>1 && getBalanceFactor(node.left)>=0){
			return rightRotate(node);
	
		}else if(bf>1 && getBalanceFactor(node.left)<0){
			node.left=leftRotate(node.left);
			return rightRotate(node);
			
		}else if(bf<-1 && getBalanceFactor(node.right)<=0){
			return leftRotate(node);
			
		}else if(bf<-1 && getBalanceFactor(node.right)>0){
			node.right=rightRotate(node.right);
			return leftRotate(node);
			
		}
		
		return node;		
	}
	
	public AVLNode insert(AVLNode node,int data){
		if(node==null)
			return new AVLNode(data);
		if(node.data<data)
			node.right=insert(node.right,data);
		else if(node.data>data)
			node.left=insert(node.left,data);
		else
			return node;
		node.height=Math.max(height(node.left),height(node.right))+1;
		int bf=getBalanceFactor(node);
		if(bf>1 && data<node.left.data){
			return rightRotate(node);
		}
		else if(bf>1 && data>node.left.data){
			node.left=leftRotate(node.left);
			return rightRotate(node);
		}
		else if(bf<-1 && data>node.right.data){
			return leftRotate(node);
		}
		else if(bf<-1 && data<node.right.data){
			node.right=rightRotate(node.right);
			return leftRotate(node);
		}	
		return node;		
	}
	
	public void inOrderTraversal(AVLNode node){
		if(node==null)
			return;
		inOrderTraversal(node.left);
		System.out.print(node.data+" ");
		inOrderTraversal(node.right);
		
	}
	

	public static void main(String[] args) {
		AVLTree tree=new AVLTree();
		tree.root=tree.insert(tree.root,10);
		tree.root=tree.insert(tree.root,20);
		tree.root=tree.insert(tree.root,30);
		tree.root=tree.insert(tree.root,40);
		tree.root=tree.insert(tree.root,50);
		tree.root=tree.insert(tree.root,25);
		tree.root=tree.insert(tree.root,32);
		tree.root=tree.insert(tree.root,35);
		/*tree.root=tree.insert(tree.root,28);
		tree.root=tree.insert(tree.root,17);
		tree.root=tree.insert(tree.root,7);
		tree.root=tree.insert(tree.root,26);
		tree.root=tree.insert(tree.root,72);
		tree.root=tree.insert(tree.root,33);
		tree.root=tree.insert(tree.root,44);
		tree.root=tree.insert(tree.root,61);*/
		System.out.println("Height:"+tree.root.height);
		tree.root=tree.delete(tree.root,25);
		tree.inOrderTraversal(tree.root);
		System.out.println();
		System.out.println("Height:"+tree.root.height);
	}
	
	class AVLNode{
		AVLNode left,right;
		int data,height;
		AVLNode(int data){
			this.data=data;
			this.height=1;
		}
	}

}
