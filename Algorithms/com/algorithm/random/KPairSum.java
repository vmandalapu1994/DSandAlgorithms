package com.algorithm.random;

import java.util.Arrays;
import java.util.Scanner;

public class KPairSum {

	public static void main(String[] args) {
		int arr[];
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int x=sc.nextInt();
		Arrays.sort(arr);
		int start=0,end=arr.length-1;
		int sum=0;
		boolean isPairFound=false;
		while(start<end){
			sum=arr[start]+arr[end];
			if(sum==x){
				isPairFound=true;
				System.out.println("Pair is:("+arr[start]+","+arr[end]+")");
				break;
			}
			else if(sum>x){
				end--;
			}
			else
				start++;
			
		}
		if(!isPairFound){
			System.out.println("No pair is found whose sum is:"+x);
		}
	}

}
