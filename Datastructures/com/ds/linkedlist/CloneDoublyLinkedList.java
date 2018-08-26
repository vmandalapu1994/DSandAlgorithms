package com.ds.linkedlist;

public class CloneDoublyLinkedList {
	
	public static DoublyNode root;

	public static void print(DoublyNode root){
		while(root!=null){
			System.out.print(root.data+" ");
			if(root.next!=null)
				System.out.print(root.next.data+" ");
			else 
				System.out.print("NA"+" ");
			if(root.random!=null)
				System.out.println(root.random.data+" ");
			else
				System.out.println("NA");
			root=root.next;
			
		}
	}
	
	public static DoublyNode clone(DoublyNode root){
		DoublyNode temp=root,temp1=null;
		while(temp!=null){
			temp1=temp.next;
			temp.next=new DoublyNode(temp.data);
			temp.next.next=temp1;
			temp=temp1;
		}
		temp=root;
		while(temp!=null){
			temp.next.random=temp.random.next;
			temp=temp.next.next;
		}
		
		temp=root.next;
		DoublyNode original=root,copy=temp;
		while(original!=null && copy!=null){
			original.next=original.next!=null?original.next.next:original.next;
			copy.next=copy.next!=null?copy.next.next:copy.next;
			original=original.next;
			copy=copy.next;	
		}
		return temp;
		
	}
	
	public static void main(String[] args) {
		root=new DoublyNode(1);
		root.next=new DoublyNode(2);
		root.next.next=new DoublyNode(3);
		root.next.next.next=new DoublyNode(4);
		root.next.next.next.next=new DoublyNode(5);
		root.next.random=root;
		root.random=root.next.next;
		root.next.next.random=root.next.next.next.next;
		root.next.next.next.random=root.next.next.next.next;
		root.next.next.next.next.random=root.next;
		System.out.println("Original List:");
		print(root);
		DoublyNode copy=clone(root);
		System.out.println("Cloned List:");
		print(copy);
	}

}

class DoublyNode{
	int data;
	DoublyNode next,random;
	DoublyNode(int data){
		this.data=data;
		next=random=null;
	}
}
