package com.algorithm.patternsearching;

import java.util.Scanner;

public class RabinKarpAlgorithm {
	public static int d=256,q=101;
	public static void findPattern(char[] s,char[] pat){
		int p=0,t=0,h=1;
		int n=s.length;
		int m=pat.length;
		for(int i=0;i<m-1;i++)
			h=(h*d)%q;
		for(int i=0;i<=m-1;i++){
			p=(p*d+pat[i])%q;
			t=(t*d+s[i])%q;
		}
		for(int i=0;i<=n-m;i++){
			if(p==t){
				int j=0;
				for(;j<=m-1;j++){
					if(s[i+j]!=pat[j])
						break;
				}
				if(j==m){
					System.out.println("Pattern is found at index:"+i);
				}
			}
			if(i<n-m){
				t=(d*(t-s[i]*h)+s[i+m])%q;
				if(t<0)
					t+=q;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s = sc.next();
		String pat = sc.next();
		findPattern(s.toCharArray(),pat.toCharArray());
		sc.close();
	}

}
