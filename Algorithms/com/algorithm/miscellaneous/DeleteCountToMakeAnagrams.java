package com.algorithm.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Min no of characters to be removed to make the two strings Anagrams.
 *
 */
public class DeleteCountToMakeAnagrams {

	public static void main(String[] args) {
		String s1="abc",s2="cde";
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		Map<Character,Integer> m1=new HashMap<Character,Integer>();
		Map<Character,Integer> m2=new HashMap<Character,Integer>();
		for(int i=0;i<ch1.length;i++){
			if(m1.get(ch1[i])==null)
				m1.put(ch1[i],1);
			else
				m1.put(ch1[i],m1.get(ch1[i])+1);
		}
		for(int i=0;i<ch2.length;i++){
			if(m2.get(ch2[i])==null)
				m2.put(ch2[i],1);
			else
				m2.put(ch2[i],m2.get(ch2[i])+1);
		}
		int deleteCount=0;
		for (Map.Entry<Character,Integer>  e1:m1.entrySet()) {
			Character key = e1.getKey();
			Integer value = e1.getValue();
			if(m2.get(key)==null)
				deleteCount+=value;
			else
				deleteCount+=Math.abs(m2.get(key)-value);	
		}
		for (Map.Entry<Character,Integer>  e2:m2.entrySet()) {
			Character key = e2.getKey();
			Integer value = e2.getValue();
			if(m1.get(key)==null)
				deleteCount+=value;
		}
		
		System.out.println("Minimum no of charcters to be deleted to make the two strings Anagrams:"+deleteCount);
		

	}

}
