package com.algorithm.graph;

import java.util.LinkedList;
import java.util.Scanner;

public class DoesPathExists {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr=new int[n][n];
		Index src=null;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==1){
					src=new Index(i,j);
				}
			}
		}
		System.out.println("Does path Exists:"+doesPathExists(arr,src));
	}
	
	public static boolean doesPathExists(int[][] arr,Index src){
		int n=arr.length;
		boolean b[][]=new boolean[n][n];
		LinkedList<Index> q = new LinkedList<Index>();
		q.add(src);
		b[src.i][src.j]=true;
		while(!q.isEmpty()){
			Index ind = q.pop();
			if(ind.i-1>=0 && !b[ind.i-1][ind.j]){
				if(arr[ind.i-1][ind.j]==2)
					return true;
				if(arr[ind.i-1][ind.j]==3){
					b[ind.i-1][ind.j]=true;
					q.add(new Index(ind.i-1,ind.j));
				}
			}
			if(ind.i+1<n && !b[ind.i+1][ind.j]){
				if(arr[ind.i+1][ind.j]==2)
					return true;
				if(arr[ind.i+1][ind.j]==3){
					b[ind.i+1][ind.j]=true;
					q.add(new Index(ind.i+1,ind.j));
				}
			}
			if(ind.j-1>=0 && !b[ind.i][ind.j-1]){
				if(arr[ind.i][ind.j-1]==2)
					return true;
				if(arr[ind.i][ind.j-1]==3){
					b[ind.i][ind.j-1]=true;
					q.add(new Index(ind.i,ind.j-1));
				}
			}
			if(ind.j+1<n && !b[ind.i][ind.j+1]){
				if(arr[ind.i][ind.j+1]==2)
					return true;
				if(arr[ind.i][ind.j+1]==3){
					b[ind.i][ind.j+1]=true;
					q.add(new Index(ind.i,ind.j+1));
				}
			}
		}
		return false;
	}

}
class Index{
	int i;
	int j;
	Index(int i,int j){
		this.i=i;
		this.j=j;
	}
}
