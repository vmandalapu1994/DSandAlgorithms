/* if sum of one number and its reverse number contains only odd digits then that number is said to be reversible */
package com.algorithm.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReversibleNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int m=n;
		List<Byte> digits=new ArrayList<Byte>();
		while(n>0){
			digits.add((byte)(n%10));
			n/=10;
		}
		int size=digits.size();
		boolean flag=true;
		int carry=0;
		for(int i=0,j=size-1,sum;i<=size/2;i++,j--){
			sum=digits.get(i)+digits.get(j)+carry;
			carry=sum/10;
			if((sum%10)%2==0){
				flag=false;
				break;
			}
				
		}
		if(carry!=0&&flag){
			if(carry%2==0)
				flag=false;
		}
		System.out.println("is "+m+" reversible?"+flag);
		sc.close();

	}

}
