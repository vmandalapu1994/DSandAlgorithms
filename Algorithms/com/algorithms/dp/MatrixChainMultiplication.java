package com.algorithms.dp;

import java.util.Scanner;

public class MatrixChainMultiplication {
	
	public static int matrixOperations(int[] arr,int n,int[][] m,int b[][]){
		int index=0;
		for(int i=n-1;i>0;i--){
			for(int j=i+1;j<=n;j++){
				int min=Integer.MAX_VALUE;
				for(int k=i;k<j;k++){
					int cost=m[i][k]+m[k+1][j]+arr[i-1]*arr[k]*arr[j];
					if(cost<min){
						min=cost;
						index=k;
					}
				}
				b[i][j]=index;
				m[i][j]=min;	
			}
		}
		
		return m[1][n];	
	}
	
	public static String  printBrackets(int[][] m,int[][] b,int i,int j){
		int n=m.length-1;
		if(i==j)
			return "A"+i;
		else if(i==j-1)
			return "A"+i+"A"+j;
		else{
			for(int k=i;k<j;k++){
				if(b[i][j]!=0){
					return "("+printBrackets(m,b,i,b[i][j])+")("+printBrackets(m,b,b[i][j]+1,j)+")";
				}
			}
			
			return "";
				
		}
		 
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n+1];
		for(int i=0;i<=n;i++)
			arr[i]=sc.nextInt();
		int[][] m=new int[n+1][n+1];
		int[][] b=new int[n+1][n+1];
		for(int i=0;i<n;i++)
			m[i][i]=0;
		System.out.println(matrixOperations(arr,n,m,b));
		System.out.println(printBrackets(m,b,1,n));
	}

}
