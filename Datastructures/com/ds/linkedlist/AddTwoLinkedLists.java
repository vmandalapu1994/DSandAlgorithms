package com.ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class AddTwoLinkedLists {
	public static int carry=0;
	public static SinglyLinkedList result=new SinglyLinkedList();
	public static void addSameSizeLists(Node list1,Node list2){
		if(list1.next!=null)
			addSameSizeLists(list1.next,list2.next);
		int total=list1.data+list2.data+carry;
		int sum=total%10;
		carry=total/10;
		result.insert(sum);	
	}
	
	public static void addCarryToRemaining(Node root,Node cur){
		if(root.next!=cur){
			addCarryToRemaining(root.next,cur);
		}
		int total=root.data+carry;
		int sum=total%10;
		carry=total/10;
		result.insert(sum);
	}
	
	public static void addLists(SinglyLinkedList list1,SinglyLinkedList list2){
		if(list1.size==list2.size){
			addSameSizeLists(list1.root,list2.root);
			if(carry!=0)
				result.insert(carry);
		}
		else{
			if(list1.size>list2.size){
				int diff=list1.size-list2.size;
				Node cur=list1.root;
				while(diff>0){
					cur=cur.next;
					diff--;
				}
				addSameSizeLists(cur,list2.root);
				addCarryToRemaining(list1.root,cur);
				if(carry!=0)
					result.insert(carry);
				
			}else{
				int diff=list2.size-list1.size;
				Node cur=list2.root;
				while(diff>0){
					cur=cur.next;
					diff--;
				}
				addSameSizeLists(list1.root,cur);
				addCarryToRemaining(list2.root,cur);
				if(carry!=0)
					result.insert(carry);
			}
		}
		
	}

	public static void main(String[] args) {
		SinglyLinkedList list1=new SinglyLinkedList();
		SinglyLinkedList list2=new SinglyLinkedList();
		list1.insert(8);
		list1.insert(6);
		//list1.insert(5);
		list2.insert(5);
		list2.insert(6);
		list2.insert(7);
		addLists(list1,list2);
		System.out.println("Sum of Two Lists:");
		Node temp=result.root;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
		
	}

}
