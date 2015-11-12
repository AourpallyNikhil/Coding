package test;

import java.util.*;

public class maxFrequencyCharacter {
	public static void main(String[] args){
		String s = "thhiisss";
		int count = 1;
		int maxCount = 0;		
		List<Character> maxList = new ArrayList<Character>();
		
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == s.charAt(i+1)){
				count++;
			}else{
				count = 1;	
			}
			
			if(count > maxCount){
				maxCount = count;
				maxList.clear();
				maxList.add(s.charAt(i));
			}else if(count == maxCount){
				maxList.add(s.charAt(i));
			}	
			if(i == s.length() - 2 && count == 1){
				maxList.add(s.charAt(i+1));
			}
		}
		System.out.println(maxList);
	}
}
