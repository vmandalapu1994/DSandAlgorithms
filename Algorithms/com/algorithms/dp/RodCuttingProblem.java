package com.algorithms.dp;

import java.util.Scanner;

public class RodCuttingProblem {
	
	public static int maxValueAfterCutting(int[]arr,int n){
		int[] m=new int[n+1];
		m[1]=arr[0];
		for(int i=2;i<=n;i++){
			int max=arr[i-1];
			for(int j=1;j<=i/2;j++){
				int temp=m[j]+m[i-j];
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
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println(maxValueAfterCutting(arr, n));
	}

}
