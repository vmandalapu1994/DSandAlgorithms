package com.algorithm.random;

import java.util.Scanner;

public class RowWiseColWiseSortedMatrix {

	public static void main(String[] args) {
		int[][] mat;
		Scanner sc=new Scanner(System.in);
		int rows = sc.nextInt();
		int cols=sc.nextInt();
		mat=new int[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				mat[i][j] = sc.nextInt();
			}
		}
		int x=sc.nextInt();
		int m=cols-1,n=0;
		boolean isFound=false;
		while(n<rows && m>=0){
			if(mat[n][m]==x){
				isFound=true;
				System.out.println(x+" is found at("+n+","+m+")");
				break;
			}
			else if(mat[n][m]>x){
				m--;
			}
			else
				n++;	
		}
		if(!isFound){
			System.out.println(x+" is not found in the matrix");
		}
		sc.close();
	}

}
