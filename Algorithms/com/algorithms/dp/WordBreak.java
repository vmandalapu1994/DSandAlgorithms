package com.algorithms.dp;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	
	public static boolean wordBreak(List<String> words,String s){
		int n = s.length();
		boolean[][] b=new boolean[n][n];
		for(int i=n-1;i>=0;i--){
			for(int j=i;j<n;j++){
				if(words.contains(s.substring(i,j+1)))
					b[i][j]=true;
				else{
					for(int k=i;k<j;k++){
						if(b[i][k]&&b[k+1][j]){
							b[i][j]=true;
							break;
						}
					}
				}
			}
		}
		return b[0][n-1];	
	}

	public static void main(String[] args) {
		List<String> words=new ArrayList<String>();
		words.add("i");
		words.add("like");
		words.add("sam");
		words.add("icecream");
		words.add("samsung");
		words.add("mobile");
		words.add("mango");
		words.add("sung");
		words.add("cream");
		words.add("ice");
		words.add("man");
		words.add("go");
		words.add("go");
		String s="ilike";
		
		System.out.println("Can Input String be written as space seperated sequence of words:"+wordBreak(words,s));
		
		

	}

}
