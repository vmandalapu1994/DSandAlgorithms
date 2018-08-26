package com.algorithms.dp;

import java.util.Scanner;

public class LongestCommonSubsequence {
	
	public static String longestCommonSubsequence(String s1,String s2,int m,int n,int[][] l){
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(ch1[i-1]==ch2[j-1])
					l[i][j]=1+l[i-1][j-1];
				else{
					l[i][j]=Math.max(l[i][j-1],l[i-1][j]);
				}
					
			}
		}
		StringBuffer sb = new StringBuffer();
		while(m>0 && n>0){
			if(l[m][n]==1+l[m-1][n-1]){
				sb.append(ch1[m-1]);
				m--;
				n--;
			}else if(l[m][n]==l[m][n-1])
				n--;
			else
				m--;
		}
		
		return sb.reverse().toString();	
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int m = s1.length();
		int n = s2.length();
		int[][] l=new int[m+1][n+1];
		System.out.println("Length of Longest Common Subsequence:"+longestCommonSubsequence(s1, s2, m, n, l));
		
	}

}
