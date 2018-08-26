package com.algorithms.dp;

import java.util.Scanner;

public class PartitionProblem {
	
	public static boolean isEqualSumPartitionPossible(int[] arr,int n){
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=arr[i];
		}
		if(sum%2==1)
			return false;
		int x=sum/2;
		boolean[][] b=new boolean[n+1][x+1];
		for(int i=0;i<=n;i++)
			b[i][0]=true;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=x;j++){
				if(j-arr[i-1]>=0)
					b[i][j]=b[i-1][j]||b[i-1][j-arr[i-1]];
				else
					b[i][j]=b[i-1][j];
			}
		}
		
		return b[n][x];	
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println("Is Equal sum partition possible?:"+isEqualSumPartitionPossible(arr,n));
	}

}
