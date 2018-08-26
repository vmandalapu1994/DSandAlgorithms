package com.algorithm.miscellaneous;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ReverseWords {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s = sc.nextLine();
		StringTokenizer st = new StringTokenizer(s," ");
		StringBuffer sb=new StringBuffer();
		while(st.hasMoreElements()){
			sb.insert(0,st.nextElement()+" ");
			/*sb.append(st.nextElement()+" ");*/
		}
		System.out.println("Reverse String is:"+sb.substring(0,sb.length()-1).toString());
	}

}
