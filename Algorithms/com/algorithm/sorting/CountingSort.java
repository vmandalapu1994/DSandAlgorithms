package com.algorithm.sorting;

import java.util.Scanner;

public class CountingSort {
	static int arr[];
	static int result[];

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size = sc.nextInt();
		arr=new int[size];
		result=new int[size];
		for(int i=0;i<size;i++){
			arr[i]=sc.nextInt();
		}
		sort();
		System.out.println("Sorted Array:");
		for(int i:result){
			System.out.print(i+" ");
		}	
	}
	public static void sort(){
		int range[]=new int[100];
		for(int i:arr){
			range[i-1]+=1;
		}
		for(int i=1;i<100;i++){
			range[i]=range[i-1]+range[i];
		}
		for(int i=arr.length-1;i>=0;i++){
			result[range[arr[i]-1]]=arr[i];
			range[arr[i]-1]--;
		}
	}

}
