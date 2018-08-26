package com.ds.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {
	
	public static void printRootToLeafPaths(Node root,List<Integer> path){
		if(root==null)
			return ;
		path.add(root.data);
		if(root.left==null && root.right==null){
			for(Integer i:path){
				System.out.print(i+"->");
			}
			System.out.println();
		}
		else{
			if(root.left!=null&&root.right!=null){
				List<Integer> path1=new ArrayList<Integer>();
				path1.addAll(path);
				printRootToLeafPaths(root.left,path);
				printRootToLeafPaths(root.right,path1);
			}else{
				if(root.left!=null)
					printRootToLeafPaths(root.left,path);
				else if(root.right!=null)
					printRootToLeafPaths(root.right,path);
			}
			
		}
			
	}

	public static void main(String[] args) {
		/*Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);*/
		Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
		
		List<Integer> path=new ArrayList<Integer>();
		printRootToLeafPaths(root,path);

	}

}
