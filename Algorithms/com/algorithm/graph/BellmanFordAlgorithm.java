package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BellmanFordGraph{
	int v;
	int values[];
	int temp[];
	List<BellmanFordEdge> edges=new ArrayList<BellmanFordEdge>();
	BellmanFordGraph(int v){
		this.v=v;
		values=new int[v];
		temp=new int[v];
	}
	
	public void addEdge(int u,int v,int w){
		BellmanFordEdge edge=new BellmanFordEdge(u,v,w);
		edges.add(edge);
	}
	
	public boolean isNegativeCycleExists(int src){
		Arrays.fill(values,Integer.MAX_VALUE);
		Arrays.fill(temp,Integer.MAX_VALUE);
		values[src]=0;
		temp[src]=0;
		for(int i=1;i<v;i++){
			values=Arrays.copyOf(temp,temp.length);
			for(BellmanFordEdge edge:edges){
				if(values[edge.src]!=Integer.MAX_VALUE
						&&values[edge.dest]>values[edge.src]+edge.weight){
					temp[edge.dest]=values[edge.src]+edge.weight;	
				}
				
				
			}
			
			
		}
		
		for(BellmanFordEdge edge:edges){
			if(values[edge.src]!=Integer.MAX_VALUE
					&&values[edge.dest]>values[edge.src]+edge.weight){
				return true;
			}
			
		}
		return false;	
	}
	
	public void printShortestDist(int src){
		for(int i=0;i<values.length;i++){
			if(i!=src)
				System.out.println(i+"->"+values[i]);
		}
	}
	
	
}

public class BellmanFordAlgorithm {

	public static void main(String[] args) {
		BellmanFordGraph g=new BellmanFordGraph(5);
		g.addEdge(0, 1, -1);
		g.addEdge(0, 2, 4);
		g.addEdge(1, 2, 3);
		g.addEdge(1, 3, 2);
		g.addEdge(1, 4, 2);
		g.addEdge(3, 2, 5);
		g.addEdge(3, 1, 1);
		g.addEdge(4, 3, -3);
		if(!g.isNegativeCycleExists(0)){
			g.printShortestDist(0);	
		}
		else
		{
			System.out.println("Nagative Cycle Exists in the Graph.");
		}
	}

}
class BellmanFordEdge{
	int src;
	int dest;
	int weight;
	BellmanFordEdge(int u,int v,int w){
		src=u;
		dest=v;
		weight=w;
	}
	
}