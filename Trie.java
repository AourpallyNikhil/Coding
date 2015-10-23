package test;

public class Trie {
	Trie [] alpha = new Trie[26];
	int val;
	Trie(){
		val = 0;
		for(int i = 0; i < alpha.length; i++){
			alpha[i] = null;
		}
	}
}
