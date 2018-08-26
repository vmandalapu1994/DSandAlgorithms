package com.ds.heap;


import java.util.Scanner;

public class MedianOfAStream {
	
	public static void median(){
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		MaxHeap maxHeap = new MaxHeap(n);
		MinHeap minHeap = new MinHeap(n);
		int median=0;
		int e=0,diff=0;
		for(int i=0;i<n;i++){
			diff=maxHeap.heapsize-minHeap.heapsize;
			e=sc.nextInt();
			
			if(diff==0){
				if(e>median){
					minHeap.insert(e);
					median=minHeap.getMin();
					
				}else{
					maxHeap.insert(e);
					median=maxHeap.getMax();
				}
			}else if(diff>0){
				if(e>median){
					minHeap.insert(e);
					median=(minHeap.getMin()+maxHeap.getMax())/2;
				}else{
					minHeap.insert(maxHeap.popMax());
					maxHeap.insert(e);
					median =(minHeap.getMin()+maxHeap.getMax())/2;
				}
			}else{
				if(e<median){
					maxHeap.insert(e);
					median=(minHeap.getMin()+maxHeap.getMax())/2;
					
				}else{
					maxHeap.insert(minHeap.popMin());
					minHeap.insert(e);
					median=(minHeap.getMin()+maxHeap.getMax())/2;
					
				}
				
			}
			
			System.out.println("Median is:"+median);	
		}
		
		
	}

	public static void main(String[] args) {
		median();
	}

}
