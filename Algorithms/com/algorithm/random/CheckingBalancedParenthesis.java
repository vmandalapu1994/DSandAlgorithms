package com.algorithm.random;

import java.util.Scanner;
import java.util.Stack;

public class CheckingBalancedParenthesis {
	
	public static boolean isMatching(char ch1,char ch2){
		if(ch1=='{' && ch2=='}')
			return true;
		if(ch1=='[' && ch2==']')
			return true;
		if(ch1=='(' && ch2==')')
			return true;
		return false;	
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String exp=sc.next();
		Stack<Character> stack=new Stack<Character>();
		char[] charArray = exp.toCharArray();
		boolean flag=true;
		for(int i=0;i<charArray.length;i++){
			if(charArray[i]=='{'|| charArray[i]=='(' || charArray[i]=='['){
				stack.push(charArray[i]);
			}
			else{
				if(stack.isEmpty()){
					System.out.println("Expression is not Balanced");
					flag=false;
					break;	
				}	
				char ch = stack.pop();
				if(!isMatching(ch,charArray[i])){
					System.out.println("Expression is not Balanced");
					flag=false;
					break;
				}		
			}
		}
		if(!stack.isEmpty()){
			System.out.println("Expression is not Balanced");
			flag=false;
		}
		if(flag)
			System.out.println("Expression is Balanced");

	}

}
