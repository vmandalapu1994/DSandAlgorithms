package com.ds.binarytree;

public class KDistanceNodesFromAnyNode {
	
	public static int kDistanceNodesFromAnyNode(Node root,int node,int dist){
		if(root==null)
			return -1;
		if(root.data==node){
			KDistanceNodesFromRoot.printKDistNodes(root,dist);
			return 0;	
		}
		int dl=kDistanceNodesFromAnyNode(root.left,node,dist);
		int dr=kDistanceNodesFromAnyNode(root.right,node,dist);
		if(dl!=-1){
			if(dl+1==dist){
				System.out.println(root.data);
			}else{
				KDistanceNodesFromRoot.printKDistNodes(root.right,dist-dl-2);
			}
			return dl+1;
			
		}else if(dr!=-1){
			if(dr+1==dist){
				System.out.println(root.data);
			}else{
				KDistanceNodesFromRoot.printKDistNodes(root.left,dist-dr-2);
			}
			return dr+1;	
		}
		return -1;	
	}

	public static void main(String[] args) {
		Node root=new Node(20);
		root.left=new Node(8);
		root.left.left=new Node(4);
		root.left.right=new Node(12);
		root.left.right.left=new Node(10);
		root.left.right.right=new Node(14);
		root.right=new Node(22);
		kDistanceNodesFromAnyNode(root,10,2);
	}

}


