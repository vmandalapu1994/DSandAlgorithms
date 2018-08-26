//Find the Next Greater element using the  set of digits

package com.algorithm.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NextGreaterNumber {
	public static byte[] getDigits(int n){
		List<Byte> digits=new ArrayList<Byte>();
			
		while(n>0){
			digits.add((byte)(n%10));
			n/=10;
		}
		byte[] b=new byte[digits.size()];
		int i=b.length-1;
		for(byte b1:digits){
			b[i]=b1;
			i--;
		}
		return b;
	}
	
	public static boolean isDecreasinglySorted(byte[] arr,int i,int j){
		for(int m=i+1;m<j;m++){
			if(arr[m]>arr[m-1])
				return false;
		}
		return true;
	}
	
	public static int findMinIndex(byte[] d,int i,int j){
		int min=i;
		for(int m=i+1;m<j;m++){
			if(d[min]>d[m])
				min=m;
		}
		return min;	
	}
	
	public static int getNumberFromDigits(byte[] b){
		int n=0;
		for(byte b1:b){
			n=n*10+b1;
		}
		return n;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		byte[] d=getDigits(n);
		int l=d.length;
		boolean flag=false;
		for(int j=l-2;j>=0;j--){
			if(d[j]<d[j+1]){
				flag=true;
				byte ele=d[j];
				d[j]=d[l-1];
				d[l-1]=ele;
				Arrays.sort(d,j+1,l);
				break;
			}
			
		}
		if(!flag)
			System.out.println("Greater element is not possible");
		else
			System.out.println("Next Greater Element is:"+getNumberFromDigits(d));

	}

}
