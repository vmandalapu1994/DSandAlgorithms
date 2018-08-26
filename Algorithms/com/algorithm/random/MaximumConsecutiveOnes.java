//Find the positions of zeros to be flipped to get the maximumno of consecutive ones

package com.algorithm.random;

import java.util.Scanner;

public class MaximumConsecutiveOnes {
	public static void findPosOfZeroesFlipped(byte[] arr,int n,int m){
		int wL=0,wR=0;
		int zeroCount=0;
		int bestL=0,bestLength=0;
		while(wR<n){
			if(zeroCount<=m){
				if(arr[wR]==0){
					zeroCount++;
				}
				wR++;
			}
			while(zeroCount>m){
				if(arr[wL]==0)
					zeroCount--;
				wL++;
			}
			if((wR-wL)>bestLength){
				bestL=wL;
				bestLength=wR-wL;
			}
				
		}
		System.out.println("Maximum Consective Ones:"+bestLength);
		System.out.println("Position of zeroes to be flipped:");
		for(int i=0;i<bestLength;i++){
			if(arr[bestL+i]==0){
				System.out.print(bestL+i+1+" ");
			}
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		byte[] arr=new byte[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextByte();
		}
		int m=sc.nextInt();
		findPosOfZeroesFlipped(arr,n,m);

	}

}
