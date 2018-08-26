package com.algorithms.dp;

public class EditDistance {
	
	public static int min(int a,int b,int c){
		return a<b?a<c?a:c:b<c?b:c;
	}
	
	public static int editDistance(int[][] d,String s1,String s2){
		int m=s1.length(),n=s2.length();
		char[] c1 = s1.toCharArray();
		char c2[]=s2.toCharArray();
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(c1[i-1]==c2[j-1])
					d[i][j]=d[i-1][j-1];
				else{
					d[i][j]=1+min(d[i][j-1],d[i-1][j],d[i-1][j-1]);	
				}
			}
		}
		return d[m][n];
	}
	
	

	public static void main(String[] args) {
		String s1="abc",s2="xyz";
		int m=s1.length(),n=s2.length();
		int[][] d=new int[m+1][n+1];
		for(int i=0;i<=m;i++)
			d[i][0]=i;
		for(int i=0;i<=n;i++)
			d[0][i]=i;
		
		System.out.println("No of operations needed:"+editDistance(d,s1,s2));
	}

}
