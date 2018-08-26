

package com.algorithm.random;

import java.util.Scanner;

/**
 * Merge array of size m having m elements into another array of size m+n having n elements so that output is sorted.
 *
 */
public class MergeSort {
	
	public static void merge(int[] arr1,int[] arr2){
		int n1=arr1.length;
		int n2=arr2.length;
		int j=0,p=0,i=0;
		for(int k=0;k<n1;k++){
			if(arr1[k]!=-1){
				i=k;
				break;
			}
		}
		while(i<n1 && j<n2){
			if(arr1[i]>arr2[j]){
				if(arr1[p]!=-1){
					int x=0;
					for(int k=p+1;k<n1;k++){
						if(arr1[k]==-1){
							x=k;
							break;
						}
					}
					x--;
					if(i>=p&&i<=x)
						i++;
					while(x>=p){
						arr1[x+1]=arr1[x];	
						x--;
					}
					arr1[p]=-1;
					
				}
				arr1[p]=arr2[j];
				p++;
				j++;
				
			}else{
				int val=arr1[i];
				arr1[i]=-1;
				arr1[p]=val;
				p++;
				boolean flag=false;
				for(int k=i+1;k<n1;k++){
					if(arr1[k]!=-1){
						i=k;
						flag=true;
						break;
					}
				}
				if(!flag)
					i=n1;
				
			}
		}
		
		if(j<n2){
			for(int k=p;k<n1;k++){
				if(arr1[k]==-1){
					arr1[k]=arr2[j];
					j++;
				}
			}
		}
		System.out.println("Merged array:");
		for(int ele:arr1){
			System.out.print(ele+" ");	
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n1 = sc.nextInt();
		int[] arr1=new int[n1];
		for(int i=0;i<n1;i++)
			arr1[i]=sc.nextInt();
		int n2=sc.nextInt();
		int[] arr2=new int[n2];
		for(int i=0;i<n2;i++)
			arr2[i]=sc.nextInt();
		merge(arr1,arr2);
	}

}
