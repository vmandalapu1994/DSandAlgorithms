package com.algorithm.graph;

import java.util.Arrays;

public class FloydWarshallAlgorithm {
	int[][] adjMat;
	int v;
	FloydWarshallAlgorithm(int v){
		this.v=v;
		adjMat=new int[v][v];
		for(int i=0;i<v;i++)
			Arrays.fill(adjMat[i],Integer.MAX_VALUE);
		for(int i=0;i<v;i++)
			adjMat[i][i]=0;
	}
	
	public void addEdge(int u,int v,int w){
		adjMat[u][v]=w;
	}
	
	public void calculateAllPairsShortestPath(){
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				for(int k=0;k<v;k++){
					if(adjMat[j][i]!=Integer.MAX_VALUE&&adjMat[i][k]!=Integer.MAX_VALUE&&(adjMat[j][i]+adjMat[i][k])<adjMat[j][k])
						adjMat[j][k]=adjMat[j][i]+adjMat[i][k];
				}
			}
			
		}
	}

	public static void main(String[] args) {
		
		FloydWarshallAlgorithm g=new FloydWarshallAlgorithm(4);
		g.addEdge(0,3,10);
		g.addEdge(0,1,5);
		g.addEdge(1,2,3);
		g.addEdge(2,3,1);
		g.calculateAllPairsShortestPath();
		System.out.println("All Pairs Shortest Path Matrix:");
		for(int i=0;i<g.v;i++){
			for(int j=0;j<g.v;j++)
				System.out.print(g.adjMat[i][j]+" ");
			System.out.println();
		}
		
	}
	
	
	
	

}
