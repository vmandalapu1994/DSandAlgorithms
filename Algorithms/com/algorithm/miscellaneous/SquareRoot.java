package com.algorithm.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int sqrt(int a) {
		if(a==0)
			return 0;
		
	    List<Integer> list=getDigits(a);
	    int s=list.size(),d=0,temp=0;
	    int i=list.size()-1;
	    int div=0;
	    if(s%2==0){
	        div=div*10+list.get(i);
	        i--;
	        div=div*10+list.get(i);
	        i--;
	    }else{
	        div=div*10+list.get(i);
	        i--; 
	    }
	    int res=0;
	    for(int j=9;j>=0;j--){
	        if(j*j<=div){
	            res=res*10+j;
	            div-=j*j;
	            break;
	        }
	    }
	    
	    while(i>0){
	        div=div*10+list.get(i);
	        i--;
	        div=div*10+list.get(i);
	        i--; 
	        if(div==0)
	        res=res*10;
	        else{
	            d=res*2;
	            for(int j=9;j>=0;j--){
	                temp=d;
	                temp=(temp*10+j)*j;
        	        if(temp<=div){
        	            res=res*10+j;
        	            div-=temp;
        	            break;
        	        }
        	    }
	            
	        }
	        
	        
	        
	    }  
	    
	    
	    return res;
	    
	    
	    
	    
	    
	}
	
	public List<Integer> getDigits(int n){
	    List<Integer> list=new ArrayList<Integer>();
	    while(n>0){
	        list.add(n%10);
	        n/=10;
	    }
	    return list;
	    
	    
	    
	}

}
