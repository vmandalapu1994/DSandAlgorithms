package com.algorithm.miscellaneous;
import java.util.*;
import java.lang.*;
import java.io.*;

public class SortArrayWith3DiffElements {

	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    int count=0;
	    while(count<t){
	        int N=sc.nextInt();
	        int[] arr=new int[N];
	        for(int i=0;i<N;i++){
	            arr[i]=sc.nextInt();
	        }
	        int s=0,e=arr.length-1,i=0;
	        while(arr[i]==0){
	            i++;
	            s++;
	        }
	        while(arr[e]==2){
	            e--;
	        }
	        while(i<=e){
	            if(arr[i]==0){
	                arr[i]=arr[s];
	                arr[s]=0;
	                s++;
	                i++;
	            }else if(arr[i]==1){
	                i++;
	            }else{
	                arr[i]=arr[e];
	                arr[e]=2;
	                e--;
	               while(arr[e]==2){
        	            e--;
        	       }
	            }
	        }
	        for(i=0;i<N;i++){
	            System.out.print(arr[i]+" ");
	        }
	        System.out.println();
	        count++;
	    }
	    
		//code
	}

}
