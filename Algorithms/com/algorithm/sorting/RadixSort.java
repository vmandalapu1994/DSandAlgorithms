package com.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
	static int arr[];

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size = sc.nextInt();
		arr=new int[size];
		for(int i=0;i<size;i++)
			arr[i]=sc.nextInt();
		sort();
		System.out.println("Sorted Array:");
		for(int i:arr){
			System.out.print(i+" ");
		}
		sc.close();
	}
	public static int digitsCount(int n){
		int i=0;
		while(n>0){
			n/=10;
			i++;
		}
		return i;
	}
	public static void sort(){
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max)
				max=arr[i];
		}
		int[] input=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			input[i]=arr[i];
		}
		int[] output=new int[arr.length];
		int range[]=new int[10];
		for(int i=1;i<=digitsCount(max);i++){
			int x[]=new int[arr.length];
			for(int j=0;j<input.length;j++){
				x[j]=(input[j]/(int)Math.pow(10,i-1))%10;	
			}
			for(int k:x){
				range[k]++;
			}
			for(int k=1;k<range.length;k++)
				range[k]+=range[k-1];
			for(int k=x.length-1;k>=0;k--){
				output[range[x[k]]-1]=input[k];
				range[x[k]]--;
			}
			for(int k=0;k<output.length;k++){	
				input[k]=output[k];
			}
			Arrays.fill(range,0);
		}
		for(int i=0;i<output.length;i++)
			arr[i]=output[i];	
	}

}
