package com.ds.matrix;

import java.util.Scanner;

public class SpiralForm {
	
	public static void spiralForm(int[][] arr,int n){
		for(int r1=0;r1<n/2;r1++){
			int c1=r1,r2=n-r1-1,c2=n-c1-1;
			for(int i=c1;i<=c2;i++)
				System.out.print(arr[r1][i]+" ");
			for(int j=r1+1;j<=r2;j++)
				System.out.print(arr[j][c2]+" ");
			for(int k=c2-1;k>=c1;k--)
				System.out.print(arr[r2][k]+" ");
			for(int l=r2-1;l>r1;l--)
				System.out.print(arr[l][c1]+" ");
		}
		if(n%2==1)
			System.out.print(arr[n/2][n/2]);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				arr[i][j]=sc.nextInt();
			}
		}
		spiralForm(arr,n);

	}

}
