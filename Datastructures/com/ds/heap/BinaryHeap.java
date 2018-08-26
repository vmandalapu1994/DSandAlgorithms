package com.ds.heap;

public class BinaryHeap {
	int capacity;
	int heapsize=0;
	int[] heap;
	BinaryHeap(int capacity){
		this.capacity=capacity;
		heap=new int[capacity];
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
	public void insert(int node){
		if(heapsize==capacity){
			System.out.println("Max Heap size reached. Can't insert furthur.");
			return ;
		}
		heap[heapsize]=node;
		heapsize++;	
		int k=heapsize-1;
		while(k!=0&&heap[parent(k)]<heap[k]){
			int temp=heap[k];
			heap[k]=heap[parent(k)];
			heap[parent(k)]=temp;
			k=parent(k);
		}
	}
	public int getMax(){
		if(heapsize!=0)
			return heap[0];
		else{
			System.out.println("Heap is empty.");
			return Integer.MIN_VALUE;
		}
					
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
	public void printArray(){
		for(int i=0;i<heapsize;i++){
			System.out.print(heap[i]+" ");
		}
		System.out.println();	
	}
	public static void main(String[] args) {
		BinaryHeap h=new BinaryHeap(10);
		h.insert(10);
		h.insert(20);
		h.insert(15);
		h.insert(24);
		h.insert(9);
		h.insert(45);
		h.printArray();
		System.out.println(h.extractMax());
		h.printArray();
		h.increaseKey(1,50);
		h.printArray();
		h.deleteNode(2);
		h.printArray();

	}

}
