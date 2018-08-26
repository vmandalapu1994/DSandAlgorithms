package com.algorithm.miscellaneous;

import java.util.Scanner;

public class KthLargestElementInAnArray {
	//Insertion sort Technique
	public static void printKthLargestElement(int[] arr,int k){
		int n=arr.length;
		for(int i=0;i<k;i++){
			int temp=i;
			for(int j=i+1;j<n;j++){
				if(arr[j]>temp)
					temp=j;
			}
			int val=arr[i];
			arr[i]=arr[temp];
			arr[temp]=val;	
		}
		System.out.println("Kth Largest Number is:"+arr[k-1]);
	}
	
	//Using Heap

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		printKthLargestElement(arr,k);

	}

}
