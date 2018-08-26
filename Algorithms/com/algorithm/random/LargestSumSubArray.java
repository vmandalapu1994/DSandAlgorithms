package com.algorithm.random;

import java.util.Scanner;

public class LargestSumSubArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		int max_so_far=arr[0],max_ending_here=arr[0];
		int start=0,s=0,end=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>(max_ending_here+arr[i])){
				max_ending_here=arr[i];
				s=i;	
			}else{
				max_ending_here=max_ending_here+arr[i];
			}
			if(max_ending_here>max_so_far){
				start=s;
				end=i;
				max_so_far=max_ending_here;
			}
		}
		System.out.println("Maximum Subarray sum:"+max_so_far+" and (start,end)=("+start+","+end+")");
		

	}

}
