package test;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	
	public void merge(int input[], int first, int middle, int last){
		int i,j,k;
		int size1 = middle - first + 1;
		int size2 = last - middle;
		
		int [] L = new int[size1];
		int [] R = new int[size2];
		
		for(int m = 0; m < size1; m++){
			L[m] = input[first + m];
		}
		for(int n = 0; n < size2; n++){
			R[n] = input[middle + 1 + n];
		}
		i = 0;
		j = 0;
		k = first;
		while(i < size1 && j < size2){
			if(L[i] < R[j]){
				input[k++] = L[i];
				i++;
			}else{
				input[k++] = R[j];
				j++;
			}
		}
		while(i < size1){
			input[k++] = L[i++];
		}
		
		while(j < size2){
			input[k++] = R[j++];
		}
	}

	public void mergeSort(int [] input, int first, int last){
		if(first == last){
			return;
		}else{
			int middle = (first+last)/2;
			mergeSort(input, first, middle);
			mergeSort(input, middle + 1, last);
			merge(input, first,middle,last);
		}
	}
	
	public void doMergeSort(int [] input){
		int arrLength = input.length;
		mergeSort(input, 0, arrLength-1);
	}
	
	public static void main(String [] args){
		MergeSort obj = new MergeSort();
		int [] test = {5,4,3,2,1,3};
		obj.doMergeSort(test);
		for(int i = 0; i < test.length; i++){
			System.out.print(test[i] + " ");
		}
	}
}
