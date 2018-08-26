package com.algorithm.graph;

import java.util.Scanner;

public class NoOfIslands {
	public static int m,n,nodeCount=0;
	public static void DFS(int[][] arr,int i,int j,boolean[][] b){
		nodeCount++;
		b[i][j]=true;
		if(j+1<m && !b[i][j+1]&& arr[i][j+1]==1){
			DFS(arr,i,j+1,b);
		}
		if(j-1>=0 && !b[i][j-1] && arr[i][j-1]==1){
			DFS(arr,i,j-1,b);
		}
		if(i+1<n  && !b[i+1][j] && arr[i+1][j]==1){
			DFS(arr,i+1,j,b);
		}
		if(i+1<n && j-1>=0  && !b[i+1][j-1] && arr[i+1][j-1]==1){
			DFS(arr,i+1,j-1,b);
		}
		if(i+1<n && j+1<m && !b[i+1][j+1] && arr[i+1][j+1]==1){
			DFS(arr,i+1,j+1,b);
		}
		if(i-1>=0 && !b[i-1][j] && arr[i-1][j]==1){
			DFS(arr,i-1,j,b);
		}
		if(i-1>=0 && j-1>=0 && !b[i-1][j-1] && arr[i-1][j-1]==1){
			DFS(arr,i-1,j-1,b);
		}
		if(i-1>=0 && j+1<m && !b[i-1][j+1]  && arr[i-1][j+1]==1){
			DFS(arr,i-1,j+1,b);
		}	
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n = sc.nextInt();
		m=sc.nextInt();
		int[][] arr=new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				arr[i][j]=sc.nextInt();
		}
		boolean b[][]=new boolean[n][m];
		int count=0,max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(!b[i][j]&&arr[i][j]==1){
					nodeCount=0;
					DFS(arr,i,j,b);
					if(max<nodeCount)
						max=nodeCount;
					count++;
				}
			}
		}
		System.out.println("No of Connected Components:"+count);
		System.out.println("Max size of connected component:"+max);
		

	}

}
