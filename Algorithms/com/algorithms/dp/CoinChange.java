package com.algorithms.dp;

import java.util.Scanner;

public class CoinChange {
	
	
	public static int minNoOfCoinsToGiveAChange(int[][] c,int[] arr,int v){
		int n=arr.length;
		for(int i=1;i<=v;i++){
			for(int j=1;j<=n;j++){
				if(i-arr[j-1]>=0&&c[i-arr[j-1]][j]!=Integer.MAX_VALUE)
					c[i][j]=Math.min(1+c[i-arr[j-1]][j],c[i][j-1]);
				else
					c[i][j]=c[i][j-1];
			}
		}
		return c[v][n];
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int v=sc.nextInt();
		int[][] c=new int[v+1][n+1];
		for(int i=1;i<=v;i++)
			c[i][0]=Integer.MAX_VALUE;
		System.out.println("Min Coins to Give a Change:"+minNoOfCoinsToGiveAChange(c,arr,v));

	}

}
