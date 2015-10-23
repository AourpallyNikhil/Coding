package test;


public class TrieDS {
	Trie root;
	
	TrieDS(){
		root = new Trie();
		root.val = 0;
	}
	
	public boolean queryTrie(String input){
		char [] inputArr = input.toCharArray();
		int count = 0;
		int length = inputArr.length;
		Trie temp = this.root;
		while(count < length){
			if(temp.alpha[inputArr[count] - 97] == null){
				return false;
			}
			temp = temp.alpha[inputArr[count++] - 97];
		}
		if(count == length){
			return true;
		}
		return false;
	}
	
	public void insertToTrie(String input){
		char [] inputArr = input.toCharArray();
		int length = inputArr.length;
		Trie temp = this.root;
		int count = 0;
			//System.out.println((int)inputArr[count] - 97);
			if(temp.alpha[inputArr[count] - 97] == null){
				while(count < length){
					Trie curr = new Trie();
					temp.alpha[inputArr[count] - 97] = curr;
					temp.val = 0;
					temp = curr;
					count++;
				}
			}else{
				while(temp.alpha[inputArr[count] - 97] != null){
					temp = temp.alpha[inputArr[count] - 97];
					count++;
				}
				while(count < length){
					Trie curr = new Trie();
					temp.alpha[inputArr[count++] - 97] = curr;
					temp.val = 0;
					temp = curr;
				}
			}
			System.out.println("Inserted "+ input + " into Trie successfully!!");
	}

	public static void main(String [] args){
		TrieDS test = new TrieDS();
		test.insertToTrie("nikhil");
		test.insertToTrie("khil");
		test.insertToTrie("care");
		System.out.println(test.queryTrie("hil"));
		System.out.println(test.queryTrie("nikhil"));
		System.out.println(test.queryTrie("care"));
	}
}
