package com.algorithms.dp;

import java.util.Scanner;

public class DiceThrow {
	
	public static int noOfWays(int n,int m,int X){
		if(X>=n*m)
			return (X==m*n)?1:0;
		if(X<=n)
			return (X==n)?1:0;
		int[][] s=new int[m+1][X+1];
		s[0][0]=1;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=X;j++){
				for(int k=1;k<=m;k++){
					if(i-1>=0 && j-k>=0)
						s[i][j]+=s[i-1][j-k];
				}
			}
		}
		
		return s[n][X];
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int X = sc.nextInt();
		System.out.println("No of ways to get a sum of "+X+" is:"+noOfWays(n,m,X));

	}

}
