package com.algorithms.dp;

import java.util.Scanner;

/**
 * Find Longest path containing consecutive elements.From any cell we move move in any of the 4 directions.
 *
 */
public class LongestPathInAMatrix {
	public static int maxLength=0;
	public static int lengthOfLongestPath(int[][] mat){
		int m=mat.length;
		int n=mat[0].length;
		int[][] l=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(l[i][j]==0){
					if(maxLength<lengthOfLongestPathUtil(mat,l,m,n,i,j))
						maxLength=l[i][j];
				}
			}
		}
		return maxLength;
		
	}
	
	public static int lengthOfLongestPathUtil(int[][] mat,int[][] l,int m,int n,int i,int j){
		if(l[i][j]!=0)
			return l[i][j];
		if(j+1<n && mat[i][j+1]==mat[i][j]+1){
			if(l[i][j+1]!=0){
				l[i][j]=l[i][j+1]+1;
			}else{
				l[i][j]=1+lengthOfLongestPathUtil(mat,l,m,n,i,j+1);
			}
		}else if(j-1>=0 && mat[i][j-1]==mat[i][j]+1){
			if(l[i][j-1]!=0){
				l[i][j]=l[i][j-1]+1;
			}else{
				l[i][j]=1+lengthOfLongestPathUtil(mat,l,m,n,i,j-1);
			}
			
		}else if(i+1<m && mat[i+1][j]==mat[i][j]+1){
			if(l[i+1][j]!=0){
				l[i][j]=l[i+1][j]+1;
			}else{
				l[i][j]=1+lengthOfLongestPathUtil(mat,l,m,n,i+1,j);
			}
			
		}else if(i-1>=0 && mat[i-1][j]==mat[i][j]+1){
			if(l[i-1][j]!=0){
				l[i][j]=l[i-1][j]+1;
			}else{
				l[i][j]=1+lengthOfLongestPathUtil(mat,l,m,n,i-1,j);
			}
			
		}else{
			l[i][j]=1;
		}
		return l[i][j];
		
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int[][] mat=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				mat[i][j]=sc.nextInt();
			}
		}
		System.out.println("Length of longest path:"+lengthOfLongestPath(mat));

	}

}
