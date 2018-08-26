package com.ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {
	public static Stack s=new Stack();
	
	public static void topologocalSortUtil(DAGraph g,boolean[] visited,int v){
		visited[v]=true;
		for(Object o:g.list[v]){
			int vertex=(Integer)o;
			if(!visited[vertex])
				topologocalSortUtil(g,visited,vertex);	
		}
		s.push(v);	
	}
	
	public static void topologicalSort(DAGraph g){
		boolean visited[]=new boolean[g.v];
		for(int i=0;i<g.v;i++){
			if(!visited[i])
				topologocalSortUtil(g,visited,i);
		}
		
	}

	public static void main(String[] args) {
		DAGraph g=new DAGraph(6);
		g.addEdge(5, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		topologicalSort(g);
		System.out.println("Topological Sorting:");
		while(!s.isEmpty())
			System.out.print(s.pop()+" ");
	}

}

class DAGraph{
	int v;
	List[] list;
	DAGraph(){
		
	}
	DAGraph(int v){
		this.v=v;
		list=new ArrayList[v];
		for(int i=0;i<v;i++)
			list[i]=new ArrayList<Integer>();
		
	}
	public void addEdge(int s,int d){
		list[s].add(d);
	}
	
}
