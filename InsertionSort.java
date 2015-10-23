package test;

public class InsertionSort {
	public int[] doInsertionSort(int [] input){
		for(int i = 1; i < input.length; i++){
			int curr = input[i];
			for(int j = i - 1; j >= 0; j--){
				if(input[j] >= curr){
					input[j+1] = input[j];
					if(j == 0){
						input[0] = curr;
					}
				}else{
					input[j+1] = curr;
					break;
				}
			}
		}
		return input;
	}
}
