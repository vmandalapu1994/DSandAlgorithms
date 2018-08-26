//Value of a subarray is the xor of all its elements. We need to find out the xor of all values of subarrays.

package com.algorithm.random;

import java.util.Scanner;

public class GameOfXOR {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			int[] arr=new int[n];
			for(int j=0;j<n;j++){
				arr[j]=sc.nextInt();
			}
			if(n%2==0){
				System.out.println(0);
			}else{
				int xor=0;
				for(int j=0;j<n;j+=2){
					xor=xor^arr[j];
				}
				System.out.println(xor);
			}
		}

	}

}
