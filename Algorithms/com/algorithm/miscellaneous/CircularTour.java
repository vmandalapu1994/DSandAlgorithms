package com.algorithm.miscellaneous;

/**
 * Find the first petrol pump to start so that we can complete circular tour
 *
 */
public class CircularTour 
{ 
	public static int startIndex(int[] p,int[] d){
		int n=p.length;
		for(int i=0;i<n;i++){
			int petrol_left=0;
			boolean flag=true;
			for(int j=i;j<n;j++){
				petrol_left+=p[j];
				if(petrol_left<d[j]){
					flag=false;
					break;
				}
				petrol_left-=d[j];
			}
			if(flag){
				for(int j=0;j<i;j++){
					petrol_left+=p[i];
					if(petrol_left<d[j]){
						flag=false;
						break;
					}
					petrol_left-=d[j];
				}
			}
			if(flag)
				return i;	
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		int[] p=new int[]{6,3,7};
		int[] d=new int[]{4,6,3};
		System.out.println("Start Index for completing circular tour:"+startIndex(p,d));
	}

}
