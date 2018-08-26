package com.ds.linkedlist;

public class DoesCycleExistsInLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		Node node = list.get(5);
		Node node2 = list.get(2);
		node.next=node2;
		Node n1=list.root;
		Node n2=list.root;
		boolean flag=false;
		while(n1!=null&&n2!=null&&n2.next!=null){
			n1=n1.next;
			n2=n2.next.next;
			if(n1==n2){
				flag=true;
				break;
			}
		}
		System.out.println("Does cycle Exists?:"+flag);
		
		
		

	}

}
