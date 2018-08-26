package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimsMST {

	public static void main(String[] args) {
		PrimGraph g=new PrimGraph(5);
		g.addEdge(0, 3, 6);
		g.addEdge(0, 1, 2);
		g.addEdge(1, 3, 8);
		g.addEdge(1, 2, 3);
		g.addEdge(3, 4, 9);
		g.addEdge(2, 4, 7);
		g.addEdge(1, 4, 5);
		
	/*	PrimGraph g=new PrimGraph(9);
		g.addEdge(0,1,4);
		g.addEdge(0,7,8);
		g.addEdge(1,7,11);
		g.addEdge(1,2,8);
		g.addEdge(2,8,2);
		g.addEdge(7,8,7);
		g.addEdge(7,6,1);
		g.addEdge(8,6,6);
		g.addEdge(2,3,7);
		g.addEdge(6,5,2);
		g.addEdge(2,5,4);
		g.addEdge(3,5,14);
		g.addEdge(3,4,9);
		g.addEdge(5,4,10);*/
		g.preparePrimMST();
		g.printPrimMST();
	
	}

}

class PrimGraph{
	private static final Object PrimEdge = null;
	int v;
	List[] list;
	boolean[] mstvertices;
	int[] values;
	int[] parent;
	PrimGraph(int v){
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
		PrimEdge edge = new PrimEdge(v,w);
		list[u].add(edge);	
		PrimEdge edge1 = new PrimEdge(u,w);
		list[v].add(edge1);
	}
	
	public void preparePrimMST(){
		Arrays.fill(values,Integer.MAX_VALUE);
		Arrays.fill(parent,Integer.MAX_VALUE);
		int count=0;
		values[0]=0;
		parent[0]=-1;
		while(count<v){
			int min=min(values);
			mstvertices[min]=true;
			count++;
			for(Object o:list[min]){
				PrimEdge e=(PrimEdge)o;
				if(values[e.vertex]>e.weight && !mstvertices[e.vertex]){
					parent[e.vertex]=min;
					values[e.vertex]=e.weight;
				}
				
			}	
		}
		
	}
	
	public void printPrimMST(){
		for(int i=1;i<parent.length;i++){
			/*int weight=-1;
			for(Object o:list[i]){
				PrimEdge e=(PrimEdge)o;
				if(e.vertex==parent[i])
					weight=e.weight;
					
			}*/
			System.out.println(i+"->"+parent[i]+"="+values[i]);
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


class PrimEdge{
	int vertex;
	int weight;
	PrimEdge(int u,int w){
		vertex=u;
		weight=w;
	}
}
