package com.algorithm.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubArrayWithZeroSum {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int sum=0,maxlen=0;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++){
			sum+=arr[i];
			if(arr[i]==0 && maxlen==0)
				maxlen=1;
			if(map.get(sum)!=null){
				maxlen=Math.max(maxlen,i-map.get(sum));
			}else{
				map.put(sum,i);
			}
		}
		System.out.println("Max.Length of Subarray with zero sum:"+maxlen);

	}

}
