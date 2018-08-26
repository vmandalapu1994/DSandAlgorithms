package com.algorithm.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		final List<Integer> list1=new ArrayList<Integer>();
    	list1.add(-50);
    	list1.add(-41);
    	list1.add(-40);
    	list1.add(-19);
    	list1.add(5);
    	list1.add(21);
    	list1.add(28);
    	//list1.add();
    	final List<Integer> list2=new ArrayList<Integer>();
    	list2.add(-50);
    	list2.add(-21);
    	list2.add(-10);
    	list2.add(8);
    	list2.add(10);
    	System.out.println(findMedianSortedArrays(list1,list2));

	}
	
	// DO NOT MODIFY BOTH THE LISTS
	public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	   int s1=a.size();
	   int s2=b.size();
	   if(s1==0)
		   return median(b,0,s2-1);
	   if(s2==0)
		   return median(a,0,s1-1);
	   
	   if(s1>s2){
		   return findMedianUtil(a,0,s1-1,b,0,s2-1);
	   }else{
		   return findMedianUtil(b,0,s2-1,a,0,s1-1);
	   }
		      
	}
	
	public static double findMedianUtil(List<Integer> a,int as,int ae,List<Integer> b,int bs,int be){
	    int s1=ae-as+1;
	    int s2=be-bs+1;
	    if(s2==1){
	    	if(s1==1){
	    		double a1=a.get(as);
	    		double b1=b.get(bs);
	    		return (a1+b1)/2;
	    	}else if(s1==2){
	    		double a1=a.get(as);
	    		double a2=a.get(ae);
	    		double b1=b.get(bs);
	    		if(b1<a1)
	    			return a1;
	    		else if(b1>a2)
	    			return a2;
	    		else 
	    			return b1;
	    			
	    	}else{
		    	int s=medianIndex(a,as,ae);
		    	double e=b.get(bs);
		    	if(s1%2==0){
		    		double a1=a.get(s-1);
		    		double a2=a.get(s);
		    		if(e<a1)
		    			return a1;
		    		else if(e>a2)
		    			return a2;
		    		else
		    			return e;	
		    	}else{
		    		double a1=a.get(s-1);
		    		double a2=a.get(s);
		    		double a3=a.get(s+1);
		    		if(e<a1)
		    			return a1+a2/2;
		    		else if(e>a3)
		    			return a2+a3/2;
		    		else if(e>a1 && e<a2)
		    			return e+a2/2;
		    		else 
		    			return e+a3/2;	
		    	}	
	    	
	    	}
	    }else{
	    	double m1=median(a,as,ae);
	    	double m2=median(b,bs,be);
	    	int i1=medianIndex(a,as,ae);
	    	int i2=medianIndex(b,bs,be);
	    	if(m1==m2)
	    		return m1;
	    	else if(m1>m2){
	    		if(s1%2==0)
	    			ae=i1-1;
	    		else
	    			ae=i1;
	    		return findMedianUtil(a,as,ae,b,i2,be);
	    				
	    	}else{
	    		if(s2%2==0)
	    			be=i2-1;
	    		else
	    			be=i2;
	    		return findMedianUtil(a,i1,ae,b,bs,be);	
	    	}
	    	
	    	
	    	
	    	
	    }    
	    
	}
	
	public static double median(List<Integer> arr,int s,int e){
	    int size=e-s+1;
	    if(size==1)
	    	return arr.get(s);
	    int mid=s+size/2;
	    if(size%2==0){
	  	    double d1=arr.get(mid);
	        double d2=arr.get(mid-1);
	        return (d1+d2)/2;
	        
	    }else{
	        return arr.get(mid);
	    }
	}
	
	public static int medianIndex(List<Integer> arr,int s,int e){
	    int size=e-s+1;
	    int mid=s+size/2;
	    return mid;
	}

}
