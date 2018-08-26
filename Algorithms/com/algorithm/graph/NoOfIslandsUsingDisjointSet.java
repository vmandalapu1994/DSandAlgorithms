package com.algorithm.graph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NoOfIslandsUsingDisjointSet {
	public static int n,m;
	public static Element[] elements;
	
	public static int find(int i){
		while(elements[i].parent!=i)
			i=elements[i].parent;
		return i;
	}
	
	public static void union(int x,int y){
		int px=find(x);
		int py=find(y);
		if(px!=py){
			if(elements[px].rank>elements[py].rank)
				elements[py].parent=px;
			else if(elements[px].rank<elements[py].rank)
				elements[px].parent=py;
			else{
				elements[py].parent=px;
				elements[px].rank++;
			}
		}
	}
	
	public static void DFS(int[][] arr,int i,int j,boolean[][] b){
		
		b[i][j]=true;
		if(j+1<m && !b[i][j+1]&& arr[i][j+1]==1){
			union(i*n+j,i*n+j+1);
			DFS(arr,i,j+1,b);
		}
		if(j-1>=0 && !b[i][j-1] && arr[i][j-1]==1){
			
			union(i*n+j,i*n+j-1);
			DFS(arr,i,j-1,b);
		}
		if(i+1<n  && !b[i+1][j] && arr[i+1][j]==1){
		
			union(i*n+j,(i+1)*n+j);
			DFS(arr,i+1,j,b);
		}
		if(i+1<n && j-1>=0  && !b[i+1][j-1] && arr[i+1][j-1]==1){
			
			union(i*n+j,(i+1)*n+j-1);
			DFS(arr,i+1,j-1,b);
		}
		if(i+1<n && j+1<m && !b[i+1][j+1] && arr[i+1][j+1]==1){
			
			union(i*n+j,(i+1)*n+j+1);
			DFS(arr,i+1,j+1,b);
		}
		if(i-1>=0 && !b[i-1][j] && arr[i-1][j]==1){
			union(i*n+j,(i-1)*n+j);
			DFS(arr,i-1,j,b);
		}
		if(i-1>=0 && j-1>=0 && !b[i-1][j-1] && arr[i-1][j-1]==1){
			union(i*n+j,(i-1)*n+j-1);
			DFS(arr,i-1,j-1,b);
		}
		if(i-1>=0 && j+1<m && !b[i-1][j+1]  && arr[i-1][j+1]==1){
			union(i*n+j,(i-1)*n+j+1);
			DFS(arr,i-1,j+1,b);
		}	
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n = sc.nextInt();
		m=sc.nextInt();
		elements=new Element[n*m];
		int[][] arr=new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				arr[i][j]=sc.nextInt();
		}
		boolean b[][]=new boolean[n][m];
		for(int i=0;i<(m*n);i++){
			int row=i/n;
			int column=i%n;
			if(arr[row][column]==1)
				elements[i]=new Element(1,i);
			else
				elements[i]=new Element(1,-1);	
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(!b[i][j]&&arr[i][j]==1){
					DFS(arr,i,j,b);
				}
			}
			
		}
		
		Set<Integer> dis=new HashSet<Integer>();
		for(Element e:elements){
			if(e.parent!=-1)
				dis.add(e.parent);
		}
		System.out.println("No of Islands:"+dis.size());
		
	}

}

