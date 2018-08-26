package com.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class UndirectedGraph{
	int v;
	List<Integer> src=new ArrayList<Integer>();
	List<Integer> dest=new ArrayList<Integer>();
	class Element{
		int parent;
		int rank;
	}
	Element[] elements;
	UndirectedGraph(int v){
		this.v=v;
		elements=new Element[v];
		for(int i=0;i<v;i++){
			elements[i]=new Element();
			elements[i].parent=i;
			elements[i].rank=0;
		}
	}
	
	public void addEdge(int u,int v){
		src.add(u-1);
		dest.add(v-1);
	}
	
	public int find(int v){
		if(elements[v].parent!=v)
			elements[v].parent=find(elements[v].parent);
		return elements[v].parent;
	}
	
	public void union(int x,int y){
		int xr=find(x);
		int yr=find(y);
		if(elements[xr].rank>elements[yr].rank)
			elements[yr].parent=xr;
		else if(elements[xr].rank<elements[yr].rank)
			elements[xr].parent=yr;
		else{
			elements[yr].parent=xr;
			elements[xr].rank++;
		}	
	}
	
	public boolean doesGraphContainCycle(){
		for(int i=0;i<src.size();i++){
			int r1 = find(src.get(i));
			int r2=find(dest.get(i));
			if(r1==r2)
				return true;
			union(r1,r2);
		}
		
		return false;
	}
}

public class DetectCycleinUndirectedGraph {
	
		
	public static void main(String[] args) {
		UndirectedGraph g=new UndirectedGraph(4);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		//g.addEdge(4, 1);
		System.out.println("Does Graph contains Cycle?:"+g.doesGraphContainCycle());	
	}

}

