package com.ds.linkedlist;

public class IsSinglyLinkedListPalindrome {

	public static void main(String[] args) {
		SinglyLinkedList list=new SinglyLinkedList();
		list.insert(3);
		list.insert(6);
		list.insert(1);
		list.insert(5);
		list.insert(3);
		list.insert(6);
		list.insert(3);
		list.traverseList(list.root);
		Node n=null;
		if(list.size%2==0)
			n=list.get(list.size/2);
		else
			n=list.get(list.size/2+1);
		n.next=list.reverse(n.next, null);
		list.traverseList(list.root);
		boolean flag=true;
		Node n1=list.root;
		Node n2=n.next;
		for(int i=1;i<=list.size/2;i++){
			if(n1.data!=n2.data){
				flag=false;
				break;
			}
			n1=n1.next;
			n2=n2.next;
		}
		System.out.println("Is LinkedList Palindrome?:"+flag);
	}

}
