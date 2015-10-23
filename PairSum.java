package test;

import java.util.HashSet;

public class PairSum {

	public void doPairSum(int [] input, int x){
		HashSet<Integer> pairSum = new HashSet<Integer>();
		for(int i = 0; i < input.length; i++){
			if(!pairSum.contains(input[i])){
				pairSum.add(x- input[i]);
			}else{
				System.out.println(input[i]+" "+ (x - input[i]));
			}
		}
	}
	
	public static void main(String[] args){
		PairSum ob = new PairSum();
		int [] input = {1,2,2,3,4,5,7,8,9};
		ob.doPairSum(input, 10);
		
	}
}
