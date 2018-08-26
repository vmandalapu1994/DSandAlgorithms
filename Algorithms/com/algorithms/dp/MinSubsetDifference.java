package com.algorithms.dp;

import java.util.Scanner;

public class MinSubsetDifference {
	
	public static int minDifference(int[] arr,int i,int subsetsum,int totalsum){
		if(i==0)
			return Math.abs(totalsum-2*subsetsum);
		return Math.min(minDifference(arr,i-1,subsetsum+arr[i-1],totalsum),minDifference(arr,i-1,subsetsum,totalsum));	
	}
	
	public static int minSubsetDiff(int[] arr,int n,int totalsum){
		boolean[][] b=new boolean[n+1][totalsum+1];
		for(int i=0;i<=totalsum;i++)
			b[0][i]=true;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=totalsum;j++){
				b[i][j]=b[i-1][j];
				if(arr[i-1]<j)
					b[i][j]=b[i][j]|b[i-1][j-arr[i-1]];
				
			}
		}
		
		for(int j=totalsum/2;j>0;j--){
			for(int i=n;i>0;i--){
				if(b[i][j]){
					return totalsum-2*j;
				}
			}
			
		}
		
		return -1;
			
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		int totalsum=0;
		for(int i=0;i<n;i++)
			totalsum+=arr[i];
		//System.out.println("Minimum difference is:"+minDifference(arr,n,0,totalsum));
		System.out.println("Minimum difference is:"+minSubsetDiff(arr,n,totalsum));
		
	}
	
	

}
