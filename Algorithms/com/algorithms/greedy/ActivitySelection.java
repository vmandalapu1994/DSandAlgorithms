package com.algorithms.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class ActivitySelection {
	
	public static void main(String[] args){
		/*Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		map.put(3, 4);
		map.put(1, 2);
		map.put(0, 6);
		map.put(8, 9);
		map.put(5, 7);
		map.put(5,9);
		System.out.println(map);*/
		
		int s[]=new int[6];
		int f[]=new int[6];
		
		Map<IntegerDemo,Integer> m=new TreeMap<IntegerDemo,Integer>();
		m.put(new IntegerDemo(4) ,3);
		m.put(new IntegerDemo(2) ,1);
		m.put(new IntegerDemo(6) ,0);
		m.put(new IntegerDemo(9) ,8);
		m.put(new IntegerDemo(7) ,5);
		m.put(new IntegerDemo(9) ,5);
		int i=0;
		for(Map.Entry<IntegerDemo,Integer> m1:m.entrySet()){
			f[i]=m1.getKey().x;
			s[i]=m1.getValue();
			i++;
		}
		for(int a:s){
			System.out.print(a+" ");
		}
		System.out.println();
		for(int a:f){
			System.out.print(a+" ");
		}
		System.out.println();
		int finishtime=-1,totaltime=11,count=0;;
		i=0;
		List index=new ArrayList<>();
		while(i<s.length){
			if(f[i]>totaltime){
				break;
			}
			else if(finishtime<=s[i]){
				index.add(i+1);
				finishtime=f[i];
				i++;
				count++;
			}
			else
				i++;
		}
		System.out.println("No of activities can be done:"+count);
		System.out.println("Activities that can be done:");
		for(Object j:index){
			System.out.print((int)j+" ");
		}
	}
	
	

}

class IntegerDemo implements Comparable{
	int x;

	@Override
	public int compareTo(Object o) {
		IntegerDemo d=(IntegerDemo)o;
		if(this.x>d.x)
			return 1;
		else if(this.x<d.x)
			return -1;
		else 
			return 1;
	}
	public IntegerDemo(int a){
		this.x=a;
		
	}
	
}
