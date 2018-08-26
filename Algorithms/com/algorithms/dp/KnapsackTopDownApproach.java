package com.algorithms.dp;

public class KnapsackTopDownApproach {
	static int v[]={60,50,30};
	static int w[]={10,40,30};
	static int wt=40;
	static int no=w.length;
	static int hv[][]=new int[wt+1][no+1];
	

	public static void main(String[] args) {
		for(int i=0;i<=wt;i++){
			for(int j=0;j<=no;j++){
				hv[i][j]=Integer.MAX_VALUE;
			}
		}
		for(int i=0;i<=wt;i++){
			hv[i][0]=0;
		}
		for(int i=0;i<=no;i++){
			hv[0][i]=0;
		}
		System.out.println(knapsack(wt,no));
		

	}
	public static int knapsack(int w1,int v1){
		if(hv[w1][v1]!=Integer.MAX_VALUE)
			return hv[w1][v1] ;
		if(w[v1-1]>w1)
			hv[w1][v1]=knapsack(w1,v1-1);
		else
			hv[w1][v1]=Math.max(v[v1-1]+knapsack(w1-w[v1-1],v1-1),knapsack(w1,v1-1));
		return hv[w1][v1];
			
	}

}
