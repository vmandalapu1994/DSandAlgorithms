package com.algorithms.dp;

import java.util.Scanner;

public class NoOfWaystoCoverDistance {
	
	public static int noOfWays(int n){
		int[] ways=new int[n+1];
		ways[0]=1;
		ways[1]=1;
		ways[2]=2;
		for(int i=3;i<=n;i++){
			ways[i]=ways[i-1]+ways[i-2]+ways[i-3];
		}
		return ways[n];
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("No of ways:"+noOfWays(n));

	}

}
