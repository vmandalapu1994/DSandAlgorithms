package com.algorithm.miscellaneous;

import java.util.Stack;

public class InfixToPostfix {
    public static boolean isOperand(char ch){
    	return (ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')?true:false;
    }
    public static int precedence(char operator){
    	switch(operator){
    	case '+':
    	case '-':return 1;
    	
    	case '*':
    	case '/':return 2;
    	
    	default:return -1;
    	}
    	
    }
	public static void infixToPostfix(char[] infix){
		Stack s=new Stack<Character>();
		for(char ch:infix){
			if(isOperand(ch))
				System.out.println(ch);
			else
			{
				if(ch=='(')
					s.push(ch);
				else if(s.isEmpty()||precedence(ch)> precedence((char)s.peek())){
					s.push(ch);
				}
				else if(ch==')'){
					while((char)s.peek()!='('){
						System.out.println(s.pop());
					}
					s.pop();
				}
				else
				{
					while(!s.isEmpty()&&precedence(ch)<=precedence((char)s.peek())){
						System.out.println(s.pop());
					}
					s.push(ch);
				}
				
			}
			
		}
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
		
	}
	public static void main(String[] args) {
	   char[] infix={'a','*','(','b','+','c',')'};
	   infixToPostfix(infix);
	   
	}

}
