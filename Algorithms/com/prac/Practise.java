package com.prac;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
public class Practise {
    public static boolean isPower(int a) {
    	if(a==1)
    		return true;
        for(int i=2;i<=(int)Math.sqrt(a);i++){
            int j=2;
            while(true){
                if(((int)Math.pow(i,j))==a)
                    return true;
                else if (((int)Math.pow(i,j))>a)
                    break;
                else
                    j++;
            }
        }
        return false;
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	//ListNode l1=new ListNode(1);
    	//l1.next=new ListNode(5);
    	//l1.next.next=new ListNode(10);
    	//ListNode l2=new ListNode(6);
    	//l2.next=new ListNode(3);
    	//l2.next.next=new ListNode(8);
    	/*ListNode l3=new ListNode(4);
    	l3.next=new ListNode(12);
    	l3.next.next=new ListNode(15);*/
    	/*l1.next.next.next=new ListNode(7);
    	l1.next.next.next.next=new ListNode(984);
    	l1.next.next.next.next.next=new ListNode(914);
    	l1.next.next.next.next.next.next=new ListNode(903);
    	l1.next.next.next.next.next.next.next=new ListNode(992);
    	l1.next.next.next.next.next.next.next.next=new ListNode(522);*/
    	/*ArrayList<ListNode> list=new ArrayList<ListNode>();
    	list.add(l1);
    	list.add(l2);
    	//list.add(l3);
    	ListNode root=s.mergeKLists(list);
    	while(root!=null){
    		System.out.print(root.val+"->");
    		root=root.next;
    		
    	}*/
    	/*while(root!=null){
    		System.out.println(root.val+"->");
    		root=root.next;
    	}*/
    	/*ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(4);
    	list.add(2);
    	list.add(5);
    	list.add(1);
    	list.add(3);*/
    	//String str="cool_ice_wifi";
    	/*ArrayList<String> list=new ArrayList<String>();
    	list.add("zebra");
    	list.add("dog");
    	list.add("duck");
    	list.add("dove");*/
    	/*Scanner sc=new Scanner(System.in);
    	ArrayList<Integer> arr=new ArrayList<Integer>();
    	while(sc.hasNext()){
    		arr.add(sc.nextInt());
    	}*/
    	//ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
    	/*for(int i=1;i<=20;i++){
    		System.out.println(i+":"+s.solve(i));
    	}*/
    	/*Scanner sc=new Scanner(System.in);
    	ArrayList<ArrayList<Integer>> l=new ArrayList<ArrayList<Integer>>();
    	int A=sc.nextInt();
    	int e=sc.nextInt();
    	int count=0;
    	while(count<e){
    		ArrayList<Integer> list=new ArrayList<Integer>();
    		list.add(sc.nextInt());
    		list.add(sc.nextInt());
    		list.add(sc.nextInt());
    		l.add(list);
    		count++;
    	}*/
    	ArrayList<Integer> a=new ArrayList<Integer>();
    	a.add(5);
    	a.add(4);
    	a.add(3);
    	/*a.add(10);
    	a.add(4);
    	a.add(5);
    	a.add(2);
    	a.add(1);*/
    	TreeNode root = new TreeNode(5);
    	root.left=new TreeNode(4);
    	root.right=new TreeNode(8);
    	root.left.left=new TreeNode(11);
    	root.right.left=new TreeNode(13);
    	root.right.right=new TreeNode(4);
    	root.left.left.left=new TreeNode(7);
    	root.left.left.right=new TreeNode(2);
    	root.right.right.left=new TreeNode(5);
    	root.right.right.right=new TreeNode(1);
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	list.add(5);
    	System.out.println(s.rodCut(6, list));	
    }
    
}
/*class Solution {
	public int candy(ArrayList<Integer> a) {
	    int count=0,temp=0,t=0;
	    int[] arr=new int[a.size()+1];
	    for(int i=0;i<a.size();i++){
	        if(i==a.size()-1){
	                if(a.get(i)>a.get(i-1))
    	            arr[i+1]=arr[i]+1;
    	            else if(a.get(i)==a.get(i-1))
    	            arr[i+1]=arr[i];
    	            else
    	            arr[i+1]=arr[i]-1;
	        }else{
    	        if(a.get(i+1)>=a.get(i)){
    	            if(i==0){
    	                arr[i+1]=1;
    	            }else{
        	            if(a.get(i)>a.get(i-1))
        	            arr[i+1]=arr[i]+1;
        	            else if(a.get(i)==a.get(i-1))
        	            arr[i+1]=arr[i];
        	            else
        	            arr[i+1]=arr[i]-1;
    	            }
    	        }else{
    	         temp=i+1;
    	         t=0;
    	         while(temp<a.size() && a.get(temp)<a.get(temp-1)){
    	             t++;
    	             temp++;
    	         }
    	         arr[i+1]=Math.max(t,arr[i])+1;
    	         i++;
    	         while(i<a.size() && a.get(i)<a.get(i-1)){
    	             arr[i+1]=t;
    	             t--;
    	             i++;
    	         }
    	         i--;
    	        }
	        
	        }
	    }
	    for(int i=1;i<arr.length;i++)
	    count+=arr[i];
	    return count;
	}
}*/
class Trie {
	public static int ALPHABET_SIZE=26;
	public TrieNode root=new TrieNode();
	public static void main(String[] args) {
		Trie t=new Trie();
		t.insert("vamsi");
		t.insert("vam");
		t.insert("narendra");
		t.insert("mallaiah");
		t.insert("adilakshmi");
		t.insert("krishna");
		System.out.println("Does Trie contains vamsi:"+t.search("vamsi"));
		t.delete("adi");
		System.out.println("Does Trie contains vamsi:"+t.search("vamsi"));
		System.out.println("Does Trie contains vamsi:"+t.search("adilakshmi"));
		System.out.println("Does Trie contains vamsi:"+t.search("vam"));
	}
	
	public void insert(String s){
		char[] ch = s.toCharArray();
		TrieNode temp=root;
		for (char c : ch) {
			int index=(int)c-97;
			if(temp.n[index]==null){
				temp.n[index]=new TrieNode(c);
				temp=temp.n[index];
			}else{
				temp=temp.n[index];
			}
		}
		temp.isLeaf=true;
		return;
	}
	
	public boolean search(String s){
		char[] ch = s.toCharArray();
		if(root==null)
			return false;
		TrieNode temp=root;
		for (char c : ch) {
			int index=(int)c-97;
			if(temp.n[index]==null){
				return false;
			}
			temp=temp.n[index];
		}
		if(temp.isLeaf)
			return true;
		else
			return false;
		
	}
	
	public void delete(String s){
		char[] ch = s.toCharArray();
		deleteHelper(root,ch,1,ch.length);
		return;	
	}
	
	public boolean deleteHelper(TrieNode t,char[] ch,int i,int len){
		int index=(int)ch[i-1]-97;
		if(t==null || t.n[index]==null)
			return false;
		if(i==len){
			if(!t.n[index].isLeaf)
				return false;
			t.n[index].isLeaf=false;
			if(isFreeNode(t.n[index])){
				return true;
			}
			return false;
		}
		else{
			if(deleteHelper(t.n[index],ch,i+1,len)){
				int i1=(int)ch[i]-97;
				t.n[index].n[i1]=null;
				return !t.n[index].isLeaf && isFreeNode(t.n[index]);	
			}
			return false;
		}	
	}
	
	public boolean isFreeNode(TrieNode t){
		for(int i=0;i<Trie.ALPHABET_SIZE;i++){
			if(t.n[i]!=null)
				return false;
		}
		return true;
	}

}

class TrieNode{
	boolean isLeaf=false;
	TrieNode n[]=new TrieNode[Trie.ALPHABET_SIZE];	
	char value;
	TrieNode(char ch){
		value=ch;
	}
	
	TrieNode(){
		
	}
	
	
	
}


 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
 
class Solution {
	    ArrayList<Integer> list=new ArrayList<Integer>();
	    int[][] arr=null;
	    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
	        arr=new int[A+1][A+1];
	        for(int i=A-1;i>=0;i--){
	            for(int j=i+2;j<=A;j++){
	            	int min=Integer.MAX_VALUE;
	                for(int k=i+1;k<j;k++){
	                    if(B.contains(k))
	                    if(min>(j-i)+arr[k][j]+arr[i][k])
	                    min=(j-i)+arr[k][j]+arr[i][k];
	                }
	                arr[i][j]=min;
	            }
	        }
	        getSeq(B,0,A);
	        return list;
	    }
	    
	    public void getSeq(ArrayList<Integer> B,int s,int e){
	        int i=s+1;
	        for(i=s+1;i<e;i++){
	           if(arr[s][e]==(e-s)+arr[s][i]+arr[i][e]){
	               list.add(i);
	               break;
	           } 
	        }
	        if(i!=e){
	            getSeq(B,s,i);
	            getSeq(B,i,e);
	        }
	    }
	}



		
		
		
		
		
		
		
		