package com.algorithms.dp;

import java.util.Scanner;

public class MinCostPath {
	public static int[][] c;

	public static void main(String[] args) {
		int m,n;
		Scanner sc=new Scanner(System.in);
		m = sc.nextInt();
		n=sc.nextInt();
		int[][] arr=new int[m][n];
		c=new int[m+1][n+1];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				arr[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<=m;i++)
			c[i][0]=Integer.MAX_VALUE;
		for(int i=0;i<=n;i++)
			c[0][i]=Integer.MAX_VALUE;
		c[1][1]=arr[0][0];
		int x,y;
		x=sc.nextInt();
		y=sc.nextInt();
		System.out.println(minCost(arr,x,y));

	}
	public static int minCost(int[][] arr,int x,int y){
		if(c[x][y]!=0)
			return c[x][y];
		else{
			c[x][y]=min(minCost(arr,x-1,y),minCost(arr,x,y-1),minCost(arr,x-1,y-1))+arr[x-1][y-1];
			return c[x][y];
		}
	}
	public static int min(int a,int b,int c){
		return  a<b?a<c?a:c:b<c?b:c;
	}

}
