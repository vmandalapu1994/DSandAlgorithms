package com.ds.binarytree;

public class LongestConsecutiveSequence {
	public static int max_length=1;
	
	public static int maxConsecutiveSequenceLength(Node node,int length){
		if(node==null){
			return 0;
		}
		if(node.left!=null){
			int l1=length;
			if(node.left.data==node.data+1){
				l1++;
			}else{
				if(max_length<l1){
					max_length=l1;
				}
				l1=1;	
			}
			maxConsecutiveSequenceLength(node.left,l1);
		}else{
			if(max_length<length){
				max_length=length;
			}
		}
		if(node.right!=null){
			int l2=length;
			if(node.right.data==node.data+1){
				l2++;
			}else{
				if(max_length<l2){
					max_length=l2;
				}
				l2=1;	
			}
			maxConsecutiveSequenceLength(node.right,l2);
		}else{
			if(max_length<length){
				max_length=length;
			}
		}
		return max_length;
		
	}

	public static void main(String[] args) {
		Node root=new Node(10);
		root.left=new Node(20);
		root.right=new Node(9);
		root.right.left=new Node(7);
		root.right.right=new Node(10);
		root.right.right.right=new Node(11);
		System.out.println("Length of Longest Consecutive Path:"+maxConsecutiveSequenceLength(root,1));

	}

}
