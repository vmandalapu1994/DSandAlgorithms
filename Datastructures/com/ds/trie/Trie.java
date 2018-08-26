package com.ds.trie;

public class Trie {
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
