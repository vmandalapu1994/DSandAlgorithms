package com.ds.bst;

public class CommonNodesInTwoBSTs {
	public static int[] arr1,arr2;
	public static int i=0;
	
	public static void inOrderTraversal(Node node,int[] arr){
		if(node==null)
			return;
		inOrderTraversal(node.left,arr);
		arr[i]=node.key;
		i++;
		inOrderTraversal(node.right,arr);
	}
	
	public static void printCommonNodes(int[] arr1,int[] arr2){
		int m=arr1.length;
		int n=arr2.length;
		int i1=0,i2=0;
		while(i1<m && i2<n){
			if(arr1[i1]==arr2[i2]){
				System.out.println(arr1[i1]+" ");
				i1++;
				i2++;
				
			}
			else if(arr1[i1]>arr2[i2]){
				i2++;
			}else{
				i1++;
			}
		}
		
	}

	public static void main(String[] args) {
		BinarySearchTree bst1=new BinarySearchTree();
		bst1.insert(10);
		bst1.insert(9);
		bst1.insert(23);
		bst1.insert(45);
		bst1.insert(12);
		bst1.insert(18);
		bst1.insert(55);
		BinarySearchTree bst2=new BinarySearchTree();
		bst2.insert(10);
		bst2.insert(9);
		bst2.insert(26);
		bst2.insert(45);
		bst2.insert(11);
		bst2.insert(18);
		bst2.insert(43);
		arr1=new int[bst1.size];
		arr2=new int[bst2.size];
		inOrderTraversal(bst1.root,arr1);
		i=0;
		inOrderTraversal(bst2.root,arr2);
		System.out.println("Common Nodes in BSTs:");
		printCommonNodes(arr1,arr2);
	}

}
