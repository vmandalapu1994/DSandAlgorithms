package com.ds.hashing;

import java.util.Scanner;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;
*/

class OpenAddressingWithLinearProbing {
    public static int count;
    public static Register[] reg;
    
    public static int hashfunc(int n){
        return n%count;
    }
    
    public static void main(String args[] ) throws Exception {
      Scanner sc=new Scanner(System.in);
      count=sc.nextInt();
      reg=new Register[count];
      for(int i=0;i<count;i++){
          sc.nextLine();
          insert(sc.nextInt(),sc.next());
      }
      int q=sc.nextInt();
      for(int i=0;i<q;i++){
          System.out.println(search(sc.nextInt()));
      }
    }
    
   public  static boolean insert(int key, String value){
        int index=hashfunc(key);
        int i=index;
        int x=1;
        while(reg[i]!=null){
            i=(index+x)%count;
            x++;
            if(i==index)
                return false;;
        }
        if(reg[i]==null){
            Register r=new Register();
            r.rollno=key;
            r.name=value;
            reg[i]=r;
            return true;
        }
        else
        	return false;
        
        
    }
    public static String search(int key){
        int index=hashfunc(key);
        int i=index;
        int y=1;
        while(reg[i].rollno!=key){
            i=(index+y)%count;
            y++;
            if(i==index)
            return null;
        }
        if(reg[i].rollno==key)
            return reg[i].name;
        else
        	return null;
    }
}

class Register{
    int rollno;
    String name;
}
