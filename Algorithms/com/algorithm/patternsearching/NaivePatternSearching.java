package com.algorithm.patternsearching;

import java.util.Scanner;

public class NaivePatternSearching {
	
	public static int searchForPattern(String s1,String s2){
		int l1=s1.length();
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		boolean flag;
		int l2=s2.length();
		for(int i=0;i<=l1-l2;i++){
			flag=true;
			for(int j=0;j<l2;j++){
				if(ch1[i+j]!=ch2[j]){
					flag=false;
					break;
				}
			}
			if(flag)
				return i;
		}
		return -1;
			
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String string1 = sc.next();
		String string2 = sc.next();
		int i = searchForPattern(string1,string2);
		if(i==-1)
			System.out.println("Pattern is not found");
		else
			System.out.println("Pattern is found at index:"+i);

	}

}
