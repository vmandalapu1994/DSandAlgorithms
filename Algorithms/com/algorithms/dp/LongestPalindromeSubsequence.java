package com.algorithms.dp;

public class LongestPalindromeSubsequence {
	public static int[][] palindrome;
	public static String s;
	
	public static int longestLengthOfPalindrome(char[] s,int i,int j){
		if(palindrome[i][j]!=0)
			return palindrome[i][j];
		else{
			if(s[i]==s[j]){
				palindrome[i][j]=2+longestLengthOfPalindrome(s,i+1,j-1);
			}
			else{
				palindrome[i][j]=max(longestLengthOfPalindrome(s,i+1,j),longestLengthOfPalindrome(s,i,j-1));
			}
		}
		
		return palindrome[i][j];	
	}
	
	public static int max(int a,int b){
		return a>b?a:b;
	}
	
	public static int lengthOfLongestPalindrome(char[] s){
		int l=s.length;
		for(int i=l-2;i>=0;i--){
			for(int j=i+1;j<l;j++){
				if(s[i]==s[j]){
					palindrome[i][j]=2+palindrome[i+1][j-1];	
				}
				else{
					palindrome[i][j]=max(palindrome[i+1][j],palindrome[i][j-1]);
				}
			}
		}
		
		return palindrome[0][l-1];	
	}

	public static void main(String[] args) {
		s="BBABCBCAB";
		int l=s.length();
		palindrome=new int[l][l];
		for(int i=0;i<l;i++)
			palindrome[i][i]=1;
		//System.out.println("Length of Longest Palindrome:"+longestLengthOfPalindrome(s.toCharArray(),0,l-1));
		System.out.println("Length of Longest Palindrome:"+lengthOfLongestPalindrome(s.toCharArray()));

	}

}
