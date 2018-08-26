package com.algorithms.dp;

public class Knapsack {
	
	public static void main(String[] args){
		int v[]={60,50,30};
		int w[]={10,40,30};
		int wt=50;
		int no=w.length;
		int hv[][]=new int[wt+1][no+1];
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
		
		  
		for(int i=1;i<=wt;i++){
			for(int j=1;j<=no;j++){
				if(w[j-1]>i){
					hv[i][j]=hv[i][j-1];
				}
				else
					hv[i][j]=Math.max(v[j-1]+hv[i-w[j-1]][j-1],hv[i][j-1]);
				System.out.print(hv[i][j]+" ");
				
			}
			System.out.println();
		}
		System.out.println("Max value of items that can be put in a Knapsack is:"+hv[wt][no]);
		
	}


}
