/*
 * This programs finds the count of substrings of a given string having vowel count=3
 */

package com.prac;
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
     Scanner sc=new Scanner(System.in);
     int t=sc.nextInt();
     for(int i=0;i<t;i++){
    	 sc.nextLine();
         int l=sc.nextInt();
         sc.nextLine();
         String s=sc.next();
         System.out.println(count(s,l));
     }
    }
    
    public static int count(String s,int l){
       int prev=0;
        int count=0;
        for(int i=1;i<=l;i++){
            prev=0;
            for(int j=i;j<=l;j++){
                prev=prev+(isVowel(s.charAt(j-1))?1:0);
                if(prev>3)
                    break;
                if(prev==3)
                    count++;
                
            }
        }
        return count;
    }
    
    public static boolean isVowel(char ch){
        switch(ch){
            case 'a':
            
            case 'e':
         
            case 'i':
                
            case 'o':
            case 'u':return true;
            default: return false;
                
        }
    }
}