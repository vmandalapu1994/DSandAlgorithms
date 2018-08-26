package com.algorithm.miscellaneous;

import java.util.ArrayList;

public class Subsets {
	public static ArrayList<ArrayList<Integer>> subsets=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	//list.add(2);
    	list.add(3);
    	list.add(2);
    	/*list.add(4);
    	list.add(5);*/
    	ArrayList<ArrayList<Integer>> subsets = subsets(list);
    	for(ArrayList<Integer> l:subsets){
    		System.out.println(l);
    	}

	}
	
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		subset(0,a,list);
		subsets.add(0,new ArrayList<Integer>());
		return subsets;
	}
	public static void subset(int index,ArrayList<Integer> a,ArrayList<Integer> list){
		ArrayList<Integer> list1 = new ArrayList<Integer>(list);
		list1.add(a.get(index));
		subsets.add(list1);
		if(index<a.size()-1){
			subset(index+1,a,list1);
			subset(index+1,a,list);
		}
	}

}
