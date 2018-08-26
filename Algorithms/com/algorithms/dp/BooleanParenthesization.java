package com.algorithms.dp;

import java.util.Scanner;

/**
 * Find no of ways to parenthesize the given expression so that it's value becomes true.
 *
 */
public class BooleanParenthesization {
	
	public static int[] populateNoWaysToParenthesize(int m){
		int[] n=new int[m+1];
		n[0]=0;
		n[1]=1;
		n[2]=1;
		for(int i=3;i<=m;i++){
			for(int j=1;j<i;j++){
				n[i]+=n[j]*n[i-j];
			}
		}
		return n;	
	}
	
	public static int noOfWaysToParenthesize(boolean[] s,char[] o,int m,int n,int[] N){
		int[][] w=new int[m][m];
		for(int i=0;i<m;i++)
			w[i][i]=s[i]?1:0;
		for(int i=m-2;i>=0;i--){
			for(int j=i;j<m;j++){
				for(int k=i;k<j;k++){
					if(o[k]=='&')
						w[i][j]+=w[i][k]*w[k+1][j];
					else if(o[k]=='^'){
						w[i][j]+=w[i][k]*(N[j-k]-w[k+1][j]);
						w[i][j]+=(N[k-i+1]-w[i][k])*w[k+1][j];
					}
					else if(o[k]=='|'){
						w[i][j]+=w[i][k]*w[k+1][j];
						w[i][j]+=w[i][k]*(N[j-k]-w[k+1][j]);
						w[i][j]+=(N[k-i+1]-w[i][k])*w[k+1][j];
					}
				}
			}
		}
		
		return w[0][m-1];	
	}
	
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		boolean[] s=new boolean[m];
		for(int i=0;i<m;i++)
			s[i]=sc.nextBoolean();
		int n=sc.nextInt();
		char[] o=new char[n];
		for(int i=0;i<n;i++)
			o[i]=sc.next().toCharArray()[0];
		int[] N=populateNoWaysToParenthesize(m);
		System.out.println("No of ways to parenthesize so that the result becomes true:"+noOfWaysToParenthesize(s, o, m, n, N));
		
	}

}
