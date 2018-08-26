package com.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
	int n;
    List<Integer>[] g;
    public AdjacencyList(int v){
		n=v;	
	}
    public void createGraph(){
    	g=new ArrayList[n];
    	for(int i=0;i<n;i++){
			g[i]=new ArrayList();
		}
    }
	
	public  void addEdge(int u,int v){
		g[u].add(v);
	}
	public  void printGraph(){
		for(int i=0;i<n;i++){
			System.out.println("Adjacency List for vertex:"+i);
			for(Object u:g[i]){
				System.out.print(u+"->");
				
			}
			System.out.println();
		}
	}

}


class Driver{
	public static void main(String[] args) {
		AdjacencyList list=new AdjacencyList(5);
		list.createGraph();
		list.addEdge(0,1);
		list.addEdge(0,4);
		list.addEdge(1,0);
		list.addEdge(1,2);
		list.addEdge(1,3);
		list.addEdge(1,4);
		list.addEdge(2,1);
		list.addEdge(2,3);
		list.addEdge(3,1);
		list.addEdge(3,4);
		list.addEdge(3,2);
		list.addEdge(4,0);
		list.addEdge(4,1);
		list.addEdge(4,3);
		list.printGraph();
	}
	
}
