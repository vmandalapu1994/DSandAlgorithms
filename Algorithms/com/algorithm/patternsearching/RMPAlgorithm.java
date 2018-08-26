package com.algorithm.patternsearching;

import java.util.Scanner;

public class RMPAlgorithm {
	
	public static int[] lpsArray(String pat){
		int l = pat.length();
		int[] lps=new int[l];
		lps[0]=0;
		int len=0,i=1;
		while(i<l){
			if(pat.charAt(len)==pat.charAt(i)){
				len++;
				lps[i]=len;
				i++;
			}else{
				if(len!=0){
					len=lps[len-1];
					
				}else{
					lps[i]=len;
					i++;
				}
			}
		}
		
		return lps;	
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String txt = sc.next();
		String pat = sc.next();
		findMatches(txt,pat);
	}
	
	public static void findMatches(String txt,String pat){
		int n = txt.length();
		int m = pat.length();
		int[] lps = lpsArray(pat);
		int i=0;
		int j=0;
		while(i<n){
			if(txt.charAt(i)==pat.charAt(j)){
				i++;
				j++;
			}
			else {
				if(j!=0){
					j=lps[j-1];
				}else{
					i++;
				}
				
			}
			if(j==m){
				System.out.println("Pattern found at index:"+(i-j));
				j=lps[j-1];
			}	
		}
	}
}
