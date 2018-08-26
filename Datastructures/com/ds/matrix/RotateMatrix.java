package com.ds.matrix;

import java.util.Scanner;

/**
 * @author Ashok123
 * 
 * Rotate matrix by 90 degrees anto clock wise
 *
 */
public class RotateMatrix {
	
	public static void rotateMatrix(int[][] arr,int n){
		for(int x=0;x<n/2;x++){
			for(int y=x;y<n-x-1;y++){
				int temp=arr[x][y];
				arr[x][y]=arr[y][n-x-1];
				arr[y][n-x-1]=arr[n-x-1][n-y-1];
				arr[n-x-1][n-y-1]=arr[n-y-1][x];
				arr[n-y-1][x]=temp;
			}
		}
		
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
		rotateMatrix(arr,n);
		System.out.println("Matrix After Rotation:");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		

	}

}
