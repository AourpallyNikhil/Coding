package test;

public class BubbleSort {	
	public int[] doBubbleSort(int[] input){
		int arrLength = input.length;
		for(int i = 0; i< arrLength; i++){
			for(int j = 1; j < arrLength - i; i++){
				if(input[j-1] > input[j]){
					int temp = input[j-1];
					input[j-1] = input[j];
					temp = input[j];
				}
			}
		}
		return input;
	}
}
