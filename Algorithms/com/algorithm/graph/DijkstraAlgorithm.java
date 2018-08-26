package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DijkstraGraph{
	int v;
	List[] list;
	boolean[] mstvertices;
	int[] values;
	int[] parent;
	DijkstraGraph(int v){
		this.v=v;
		list=new ArrayList[v];
		values=new int[v];
		parent=new int[v];
		mstvertices=new boolean[v];
	}
	public void addEdge(int u, int v,int w){
		if(list[u]==null)
			list[u]=new ArrayList<Edge>();
		if(list[v]==null)
			list[v]=new ArrayList<Edge>();
		DijkstraEdge edge = new DijkstraEdge(v,w);
		list[u].add(edge);	
		DijkstraEdge edge1 = new DijkstraEdge(u,w);
		list[v].add(edge1);
	}
	
	public void prepareDijkstraMST(int src){
		Arrays.fill(values,Integer.MAX_VALUE);
		Arrays.fill(parent,Integer.MAX_VALUE);
		int count=0;
		values[src]=0;
		//parent[0]=-1;
		while(count<v){
			int min=min(values);
			mstvertices[min]=true;
			count++;
			for(Object o:list[min]){
				DijkstraEdge e=(DijkstraEdge)o;
				if(values[e.vertex]>(e.weight+values[min]) && !mstvertices[e.vertex]){
					//parent[e.vertex]=min;
					values[e.vertex]=e.weight+values[min];
				}
				
			}	
		}
		
	}
	
	public void printDijkstraMST(int src){
		for(int i=0;i<values.length;i++){
			/*int weight=-1;
			for(Object o:list[i]){
				PrimEdge e=(PrimEdge)o;
				if(e.vertex==parent[i])
					weight=e.weight;
					
			}*/
			if(i!=src)
			System.out.println(i+"->"+values[i]);
		}
	}
	
	public int min(int[] arr){
		boolean flag=true;
		int k=Integer.MAX_VALUE;
		for(int i=0;i<mstvertices.length;i++){
			if(!mstvertices[i]){
				if(flag){
					k=i;
					flag=false;
				}
				else{
					if(arr[i]<arr[k])
						k=i;		
				}
			}
		}
		return k;
	}
	
}

public class DijkstraAlgorithm {

	public static void main(String[] args) {
		DijkstraGraph g=new DijkstraGraph(5);
		g.addEdge(0, 3, 6);
		g.addEdge(0, 1, 2);
		g.addEdge(1, 3, 8);
		g.addEdge(1, 2, 3);
		g.addEdge(3, 4, 9);
		g.addEdge(2, 4, 7);
		g.addEdge(1, 4, 5);
		g.prepareDijkstraMST(4);
		g.printDijkstraMST(4);
	}

}

class DijkstraEdge{
	int vertex;
	int weight;
	DijkstraEdge(int u,int w){
		vertex=u;
		weight=w;
	}
}
