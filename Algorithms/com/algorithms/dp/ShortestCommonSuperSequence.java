package com.algorithms.dp;

import java.util.Scanner;

public class ShortestCommonSuperSequence {
	
	

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		int m = s1.length();
		int n = s2.length();
		int[][] l=new int[m+1][n+1];
		String lcs = LongestCommonSubsequence.longestCommonSubsequence(s1, s2, m, n, l);
		char[] ch=lcs.toCharArray();
		int i1=0,i2=0;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<ch.length;i++){
			while(ch1[i1]!=ch[i]){
				sb.append(ch1[i1]);
				i1++;
			}
			while(ch2[i2]!=ch[i]){
				sb.append(ch2[i2]);
				i2++;
			}
			sb.append(ch[i]);
			i1++;
			i2++;
			
		}
		
		System.out.println("Shortest Common Supersequence:"+sb.toString());	

	}

	

}
