package com.algorithms.dp;

public class AssemblyLineScheduling {
	
	public static int minTime(int[][] a,int[][] t,int[] x,int[] e){
		int n=a[0].length;
		int[] t1=new int[n];
		int[] t2=new int[n];
		t1[0]=e[0]+a[0][0];
		t2[0]=e[1]+a[1][0];
		for(int i=1;i<n;i++){
			t1[i]=Math.min(t1[i-1]+a[0][i],t2[i-1]+t[1][i]+a[0][i]);
			t2[i]=Math.min(t2[i-1]+a[1][i],t1[i-1]+t[0][i]+a[1][i]);
		}
		return Math.min(t1[n-1]+x[0],t2[n-1]+x[1]);
		
	}

	public static void main(String[] args) {
		int[][] a={{4, 5, 3, 2},
                {2, 10, 1, 4}},t={{0, 7, 4, 5},
		        {0, 9, 2, 8}};
		int[] e={10, 12},x={18, 7};
		System.out.println("Minimum time for assembling:"+minTime(a,t,x,e));

	}

}
