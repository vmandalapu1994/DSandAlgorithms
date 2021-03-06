package com.algorithm.miscellaneous;

import java.util.Scanner;

public class MaxHeap {
	int[] arr;
	int heapsize;
	MaxHeap(int[] arr1){
		this.arr=arr1;
		heapsize=arr1.length;
		buildHeap(arr);
	}
	
	MaxHeap(){
		
	}
	
	public int parent(int i){
		return ((i+1)/2)-1;
	}
	
	public int left(int i){
		return 2*i+1;
	}
	
	public int right(int i){
		return 2*i+2;
	}
	
	public void buildHeap(int[] arr1){
		for(int i=heapsize/2-1;i>=0;i--){
			heapify(i);
		}	
	}
	
	public void incKey(int node,int incrementTo){
		arr[node]=incrementTo;
		int temp=node;
		while(parent(temp)>=0 && arr[parent(temp)]<arr[temp]){
			int val=arr[parent(node)];
			arr[parent(temp)]=arr[temp];
			arr[temp]=val;
			temp=parent(temp);
		}
	}
	
	public void deleteNode(int node){
		incKey(node,Integer.MAX_VALUE);
		popMax();
	}
	
	//Heapify in BottomUp manner
	public void heapify1(int node){
		if(node>heapsize-1)
			return;
		int parentnode=parent(node);
		int highestnode=node;
		if(parentnode>=0 && arr[parentnode]<arr[node])
			highestnode=parentnode;
		if(highestnode!=node){
			int temp=arr[highestnode];
			arr[highestnode]=arr[node];
			arr[node]=temp;
			heapify(highestnode);
		}
			
	}
	
	//Heapify in TopDown manner
	public void heapify(int node){
		if(node>heapsize-1)
			return;
		int leftnode=left(node);
		int rightnode=right(node);
		int highestnode=node;
		if(leftnode<heapsize && arr[leftnode]>arr[node])
			highestnode=leftnode;
		if(rightnode<heapsize && arr[rightnode]>arr[node])
			highestnode=rightnode;
		if(highestnode!=node){
			int temp=arr[highestnode];
			arr[highestnode]=arr[node];
			arr[node]=temp;
			heapify(highestnode);
		}
			
	}
	

	public int getMax(){
		return arr[0];
	}
	
	public int popMax(){
		int max=arr[0];
		arr[0]=arr[heapsize-1];
		heapsize--;
		heapify(0);
		return max;
	}
	
	public void printHeap(){
		for(int i=0;i<heapsize;i++)
			System.out.print(arr[i]+" ");
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		MaxHeap heap=new MaxHeap(arr);
		heap.printHeap();
		for(int i=0;i<k-1;i++){
			heap.popMax();
		}
		System.out.println(k+"th highest element:"+heap.getMax());
	}

}
