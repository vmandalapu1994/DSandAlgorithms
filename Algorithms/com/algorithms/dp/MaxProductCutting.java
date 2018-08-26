package com.algorithms.dp;

import java.util.Scanner;

public class MaxProductCutting {

	public static int maxProductAfterCutting(int n){
		int[] m=new int[n+1];
		m[1]=1;
		m[2]=1;
		for(int i=3;i<=n;i++){
			int max=0;
			for(int j=1;j<=i/2;j++){
				int temp=Math.max(j,m[j])*Math.max(i-j,m[i-j]);
				if(max<temp){
					max=temp;
				}
			}
			m[i]=max;
		}
		return m[n];
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(maxProductAfterCutting(n));
	}

}
