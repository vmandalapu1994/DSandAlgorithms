package com.algorithm.miscellaneous;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
	
	public static void printNGE(int[] arr){
		Stack<Integer> s=new Stack<Integer>();
		s.push(arr[0]);
		for(int i=1;i<arr.length;i++){
			int next=arr[i];
			int temp;
			while(!s.isEmpty()){
				temp = s.pop();
				if(temp<next)
					System.out.println(temp+"---->"+next);
				else{
					s.push(temp);
					break;
				}	
			}
			s.push(next);	
		}
		while(!s.isEmpty()){
			System.out.println(s.pop()+"---->"+-1);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		printNGE(arr);
	}

}
