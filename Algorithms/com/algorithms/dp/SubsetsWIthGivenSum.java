

package com.algorithms.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Vamsi
 * Print all the subsets whose sum is equal to given sum
 *
 */
public class SubsetsWIthGivenSum {
	
	static boolean[][] b;
	
	public static void isSubsetExists(int[] arr,int n,int sum){
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=sum;j++){
				if(arr[i-1]>j)
					b[i][j]=b[i-1][j];
				else
					b[i][j]=b[i-1][j] || b[i-1][j-arr[i-1]];
			}
		}
		
		if(b[n][sum]){
			System.out.println("Subset exists with the Given sum and the subsets are:");
			printSubsets(arr,n,sum,new ArrayList<Integer>());
		}else{
			System.out.println("No Subset exists with the given sum");
		}
	}
	
	public static void printSubsets(int[] arr,int n,int sum,List<Integer> list){
		if(sum==0){
			for(int i:list)
				System.out.print(i+" ");
			System.out.println();
			return ;
		}
	
		if(sum-arr[n-1]>=0 && b[n-1][sum-arr[n-1]]){
			List<Integer> list1=new ArrayList<Integer>();
			for(int i:list){
				list1.add(i);
			}
			list1.add(arr[n-1]);
			printSubsets(arr,n-1,sum-arr[n-1],list1);
			
		}
		
		if(b[n-1][sum]){
			List<Integer> list1=new ArrayList<Integer>();
			for(int i:list){
				list1.add(i);
			}
			printSubsets(arr,n-1,sum,list1);
		}	
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		int sum=sc.nextInt();
		b=new boolean[n+1][sum+1];
		for(int i=0;i<=n;i++)
			b[i][0]=true;
		isSubsetExists(arr,n,sum);
		

	}

}
