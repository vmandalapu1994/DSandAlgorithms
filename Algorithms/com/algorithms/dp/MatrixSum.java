package com.algorithms.dp;

import java.util.Arrays;
import java.util.Scanner;


class MatrixSum {
    public static void main(String args[] ) throws Exception {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int m=sc.nextInt();
       int[][] arr=new int[n][m];
       for(int i=0;i<n;i++){
       	for(int j=0;j<m;j++){
       		arr[i][j]=sc.nextInt();
       	}
       }
       int q=sc.nextInt();
       int[] x=new int[q];
       int[] y=new int[q];
       for(int i=0;i<q;i++){
    	   x[i]=sc.nextInt();
    	   y[i]=sc.nextInt();
       }
       int[][] sum=new int[n+1][m+1];
       for(int i=0;i<=n;i++)
    	   Arrays.fill(sum[i],Integer.MAX_VALUE);
       for(int i=0;i<=n;i++){
       	sum[i][0]=0;
       }
       for(int i=0;i<=m;i++){
       	sum[0][i]=0;
       }
       sum[1][1]=arr[0][0];
       System.out.println();
       for(int i=0;i<q;i++){
       	System.out.println(summation(arr,sum,x[i],y[i]));
       }
    }
    
    public static int summation(int[][] arr,int[][] sum,int x,int y){
    	if(sum[x][y]!=Integer.MAX_VALUE)
       		return sum[x][y];
       	else{
       		int val=0;
       		for(int i=0;i<x;i++){
       			val+=arr[i][y-1];
       		}
       		sum[x][y]=summation(arr,sum,x,y-1)+val;
       		return 	sum[x][y];
       		
       	}
    	
    }
}
