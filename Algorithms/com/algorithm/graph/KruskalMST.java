package com.algorithm.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class KruskalMST {
	int v;
	Set<Edge> edges=new TreeSet<Edge>();
	Set<Edge> mstEdges=new TreeSet<Edge>();
	KruskalMST(int v){
		this.v=v;
	}
	public void addEdge(int u, int v,int w){
		Edge e=new Edge();
		e.src=u;
		e.dest=v;
		e.weight=w;
		edges.add(e);
	}
	
	public int find(Element[] elements,int v){
		if(elements[v].parent!=v)
			elements[v].parent=find(elements,elements[v].parent);
		return elements[v].parent;
	}
	
	public void union(Element[] elements,int x,int y){
		int xr=find(elements,x);
		int yr=find(elements,y);
		if(elements[xr].rank>elements[yr].rank)
			elements[yr].parent=xr;
		else if(elements[xr].rank<elements[yr].rank)
			elements[xr].parent=yr;
		else{
			elements[yr].parent=xr;
			elements[xr].rank++;
		}	
	}
	
	public boolean doesGraphContainCycle(Element[] elements,List<Integer> src,List<Integer> dest){
		for(int i=0;i<src.size();i++){
			int r1 = find(elements,src.get(i));
			int r2=find(elements,dest.get(i));
			if(r1==r2)
				return true;
			union(elements,r1,r2);
		}
		
		return false;
	}
	
	public void findMST(){
		int count=0;
		for(Edge e:edges){
			List<Integer> src=new ArrayList<Integer>();
			List<Integer> dest=new ArrayList<Integer>();
			for(Edge e1:mstEdges){
				src.add(e1.src);
				dest.add(e1.dest);
			}
			src.add(e.src);
			dest.add(e.dest);
			Element[] elements=new Element[v];
			for(int i=0;i<v;i++){
				elements[i]=new Element();
				elements[i].parent=i;
				elements[i].rank=0;
			}
			if(!doesGraphContainCycle(elements, src, dest)){
				mstEdges.add(e);
				count++;
			}
			if(count==v-1)
				break;
		}
	}

	public static void main(String[] args) {
		
		KruskalMST g=new KruskalMST(4);
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 3);
		g.addEdge(1, 3, 4);
		g.addEdge(2, 3, 5);
		for(Edge e:g.edges){
			System.out.println(e.src+" "+e.dest+" "+e.weight);
		}
		g.findMST();
		System.out.println("Minimum Spanning Tree:");
		for(Edge e:g.mstEdges){
			System.out.println(e.src+"-->"+e.dest);
		}
	}

}

class Edge implements Comparable{
	int src;
	int dest;
	int weight;
	@Override
	public int compareTo(Object arg) {
		Edge e=(Edge)arg;
		if(this.weight<e.weight)
			return -1;
		else if(this.weight>e.weight)
			return 1;
		else
		return this.hashCode()>e.hashCode()?1:-1;
	}
}
class Element{
	int parent;
	int rank;
	Element(){
		
	}
	Element(int r,int p){
		parent=p;
		rank=r;
	}
}

