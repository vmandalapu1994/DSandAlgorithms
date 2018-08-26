package com.ds.heap;

import java.util.Scanner;

public class HeapSort {
	static int heap[];
	int capacity;
	int heapsize;
	HeapSort(int capacity){
		this.capacity=capacity;
		heap=new int[capacity];
		heapsize=capacity;
	}
	public  void buildHeap(){
		for(int i=(heapsize/2)-1;i>=0;i--){
			heapify(i);
		}	
	}
	
	public void heapsort(){
		int n=heapsize;
		for(int i=n-1;i>0;i--){
			int temp=heap[0];
			heap[0]=heap[i];
			heap[i]=temp;
			heapsize--;
			heapify(0);
		}
	}
	public int parent(int i){
		return (i-1)/2;
	}
	public int left(int i){
		return 2*i+1;
	}
	public int right(int i){
		return 2*i+2;
	}
	public int extractMax(){
		if(heapsize==0){
			return 0;
		}
		if(heapsize==1){
			heapsize--;
			return heap[0];
		}
		int temp=heap[0];
		heap[0]=heap[heapsize-1];
		heapsize--;
		heapify(0);
		return temp;	
	}
	public void increaseKey(int node,int key){
		heap[node]=key;
		int k=node;
		while(k!=0&&heap[parent(k)]<heap[k]){
			int temp=heap[k];
			heap[k]=heap[parent(k)];
			heap[parent(k)]=temp;
			k=parent(k);
		}
		
	}
	
	public void deleteNode(int node){
		increaseKey(node,Integer.MAX_VALUE);
		extractMax();
	}
	public void heapify(int node){
		int leftchild=left(node);
		int rightchild=right(node);
		int highestnode=node;
		if(leftchild<heapsize)
		if(heap[leftchild]>heap[node])
			highestnode=leftchild;
		if(rightchild<heapsize)
		if(heap[rightchild]>heap[highestnode])
			highestnode=rightchild;
		
		if(highestnode!=node){
			int temp=heap[node];
			heap[node]=heap[highestnode];
			heap[highestnode]=temp;
			heapify(highestnode);
		}		
	}
	public void printArray(){
		for(int i=0;i<capacity;i++){
			System.out.print(heap[i]+" ");
		}
		System.out.println();	
	}
	public static void main(String[] args) {
		
		int arr[];
		Scanner sc=new Scanner(System.in);
		int size = sc.nextInt();
		HeapSort h=new HeapSort(size);
		for(int i=0;i<size;i++){
			heap[i]=sc.nextInt();
		}
		h.buildHeap();
		h.printArray();
		h.heapsort();
		h.printArray();
	}

}
