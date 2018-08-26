package com.ds.array;

import java.util.Arrays;
import java.util.Scanner;

import com.ds.linkedlist.DoesCycleExistsInLinkedList;

public class PythagoreanTriplet {
	
	public static boolean doesPythagoreanTripletExists(int[] arr){
		int n=arr.length;
		for(int i=0;i<arr.length;i++){
			arr[i]=arr[i]*arr[i];
		}
		Arrays.sort(arr);
		for(int i=n-1;i>1;i--){
			int j=0,k=i-1;
			while(j<k){
				if(arr[j]+arr[k]==arr[i])
					return true;
				if(arr[j]+arr[k]<arr[i])
					j++;
				else
					k--;
			}
			
		}
		return false;	
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		System.out.println("Pythagorean Triplet Exists?:"+doesPythagoreanTripletExists(arr));
		

	}

}
