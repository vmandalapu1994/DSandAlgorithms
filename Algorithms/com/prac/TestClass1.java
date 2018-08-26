package com.prac;
import java.math.BigInteger;
//import for Scanner and other utility  classes
import java.util.*;


class TestClass1 {
    public static void main(String args[] ) throws Exception {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      long[] arr=new long[n];
      int[] digitsSum=new int[n];
      for(int i=0;i<n;i++){
          arr[i]=sc.nextLong();
          digitsSum[i]=sumOfDigits(arr[i]);
      }
      List<Integer> set=new ArrayList<Integer>();
      set.add(0);
      set.add(digitsSum[0]);
      for(int i=1;i<n;i++){
    	  int y=digitsSum[i];
    	  for(ListIterator<Integer> itr=set.listIterator();itr.hasNext();){
    		  int x = (Integer)itr.next();
    		  itr.add(x>y?x:y);  
    	  }    
      }
      Object[] array = set.toArray();
      BigInteger i=new BigInteger("0");
      for(Object o:array){
 
    	  Integer x=(Integer)o;
    	  BigInteger j=new BigInteger(x.toString());
    	  i=i.add(j);  
      }
      BigInteger z=new BigInteger("1000000007");
      i=i.mod(z);
      System.out.println(i.longValue());
      
    }
    
    public static int sumOfDigits(long n){
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
}
