/**
 * 
 */
package com.ds.linkedlist;

/**
 * @author Ashok123
 *
 */
public class SinglyLinkedList {
	Node root;
	int size=0;
	public Node insert(int data){
		Node node = new Node(data);
		if(root==null)
			root=node;
		else{
			node.next=root;
			root=node;	
		}
		size++;
		return root;
	}
	public Node reverse(Node start,Node end){
		Node prev=null,next=null;
		Node currNode=start;
		Node anchorNode=null;
		if(end==null){
			anchorNode=null;
		}
		else
			anchorNode=end.next;
		while(currNode!=anchorNode){
			next=currNode.next;
			currNode.next=prev;
			prev=currNode;
			currNode=next;
		}
		return prev;	
	}
	
	public Node delete(int data){
		if(root==null)
			return null;
		if(root.data==data){
			root=root.next;
			size--;
			return root;
		}else{
			Node n=root;
			while(n!=null){
				if(n.next.data==data){
					n.next=n.next.next;
					size--;
					return root;
				}
				
			}
			return root;	
		}	
	}
	
	public void traverseList(Node root){
		while(root!=null){
			System.out.print(root.data+"->");
			root=root.next;
			
		}
		System.out.println();
		
	}
	
	public Node get(int index){
		if(index<1||index>size){
			System.out.println("Invalid index number");
			return null;
		}
		Node n=root;
		int i=1;
		while(n!=null){
			if(i==index)
				return n;
			n=n.next;	
			i++;
		}
		System.out.println("No such element is found");
		return null;
	}

	
	

}

class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
	}
	
}

class LinkedListMain{
	
	public static void main(String[] args){
		SinglyLinkedList list=new SinglyLinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(24);
		list.insert(22);
		list.traverseList(list.root);
		list.root=list.reverse(list.root,null);
		list.traverseList(list.root);
		list.root=list.delete(20);
		list.traverseList(list.root);
		list.root=list.delete(10);
		list.traverseList(list.root);
		list.root=list.delete(22);
		list.traverseList(list.root);
		
		
	}
	
}
