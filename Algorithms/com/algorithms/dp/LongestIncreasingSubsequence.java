package com.algorithms.dp;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
	
	public static int lengthOfLongestIncreasingSubsequence(int[] seq,int n){
		int[] lis=new int[n];
		for(int i=0;i<n;i++)
			lis[i]=1;
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(seq[i]>seq[j] && lis[i]<lis[j]+1)
					lis[i]=lis[j]+1;		
			}
		}
		int max=1;
		for(int i=0;i<n;i++)
			if(max<lis[i])
				max=lis[i];
		return max;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		System.out.println("Length of Longest Increasing Subsequence:"+lengthOfLongestIncreasingSubsequence(arr, n));

	}

}
