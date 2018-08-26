package com.algorithm.miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SnakeAndLadder {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
		    int N=sc.nextInt();
		    Map<Integer,Integer> l=new HashMap<Integer,Integer>();
		    Map<Integer,Integer> s=new HashMap<Integer,Integer>();
		    for(int j=0;j<N;j++){
		        int a=sc.nextInt();
		        int b=sc.nextInt();
		        if(a>b){
		            s.put(a,b);
		        }else{
		            l.put(a,b);
		        }
		    }
		    int[] arr=new int[31];
		    arr[30]=0;
		    for(int k=29;k>=0;k--){
		        int min=Integer.MAX_VALUE,temp=0;
		        if(l.get(k)!=null){
		            temp=arr[l.get(k)];
		            if(temp<min){
		                min=temp;
		            }
		        }
		        /*if(s.get(k)!=null){
		            temp=arr[s.get(k)];
		            if(temp<min){
		                min=temp;
		            }
		        }*/
		        if(k+1<=30){
		            temp=1+arr[k+1];
		            if(temp<min){
		                min=temp;
		            }
		        }
		        if(k+2<=30){
		            temp=1+arr[k+2];
		            if(temp<min){
		                min=temp;
		            }
		        }
		        if(k+3<=30){
		            temp=1+arr[k+3];
		            if(temp<min){
		                min=temp;
		            }
		        }
		        if(k+4<=30){
		            temp=1+arr[k+4];
		            if(temp<min){
		                min=temp;
		            }
		        }
		        if(k+5<=30){
		            temp=1+arr[k+5];
		            if(temp<min){
		                min=temp;
		            }
		        }
		        if(k+6<=30){
		            temp=1+arr[k+6];
		            if(temp<min){
		                min=temp;
		            }
		        }
		        arr[k]=min;
		    }
		    System.out.println(arr[0]);

		}
	}
}
