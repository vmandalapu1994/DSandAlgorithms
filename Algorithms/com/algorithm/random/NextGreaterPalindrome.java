package com.algorithm.random;

import java.util.Scanner;

public class NextGreaterPalindrome {
	
	public static int[] nextGreaterPalindrome(int[] arr){
		int n=arr.length;
		int i,j;
		if(n%2==0){
			i=(n-1)/2;
			j=(n-1)/2+1;
		}else{
			i=j=(n-1)/2;	
		}
		int value=(arr[i]+1)%10;
		int carry=(arr[i]+1)/10;
		arr[i]=value;
		arr[j]=value;
		while(carry!=0&&i>0){
			i--;
			j++;
			value=(arr[i]+carry)%10;
			carry=(arr[i]+carry)/10;
			arr[i]=value;
			arr[j]=value;
		}
		if(carry!=0){
			int[] res=new int[n+1];
			res[0]=1;
			res[res.length-1]=1;
			return res;	
		}
		while(i>0){
			arr[j]=arr[i];
			i--;
			j++;
		}
		return arr;	
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		arr=nextGreaterPalindrome(arr);
		System.out.println("Next Palindrome Number is:");
		for(int i:arr){
			System.out.print(i);
		}
	}

}
