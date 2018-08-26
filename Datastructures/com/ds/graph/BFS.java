package com.ds.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		Graph list=new Graph(5);
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
		list.BFS(2);

	}

}
class Graph {
	int n;
	boolean dfsVisited[];
    List<Integer>[] g;;
    public Graph(int v){
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
	public void BFS(int s){
		boolean visited[]=new boolean[n];
		Queue<Integer> q=new ArrayDeque<Integer>();
		visited[s]=true;
		q.add(s);
		while(!q.isEmpty()){
			int v=q.poll();
			System.out.println(v);
			for(int x:g[v]){
				if(!visited[x]){
					visited[x]=true;
					q.add(x);
				}
			}
			
		}
	}
	
	public void DFSUtil(int s){
		dfsVisited[s]=true;
		System.out.println(s);
		for(int i:g[s]){
			if(!dfsVisited[i])
				DFSUtil(i);
			
		}
		
		
	}
	public void DFS(int s){
		dfsVisited=new boolean[n];
		DFSUtil(s);
		
	}

}

class DFS{
	public static void main(String[] args) {
		Graph list=new Graph(5);
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
		list.BFS(2);

	}
	
}
