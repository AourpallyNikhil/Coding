package test;

public class HeapSort {
	
	public void swap(int [] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void Heapify(int [] arr, int i, int j){
		for(int k = j; k >= 1; k--){
			if(k % 2 == 0){
				if(arr[k] > arr[(k-2)/2]){
					swap(arr, k, (k-2)/2);
				}
			}else{
				if(arr[k] > arr[(k-1)/2]){
					swap(arr, k, (k-1)/2);
				}	
			}
		}
	}
	
	public int[] doHeapSort(int [] input){
		int count = 1;
		int length = input.length;
		while(count < length){
			Heapify(input, 0, length - count);
			swap(input, 0, length - count);
			count++;
		}
		return input;	
	}

	public static void main(String [] args){
		HeapSort obj = new HeapSort();
		int [] test = {3,2,1};
		int [] output = obj.doHeapSort(test);
		for(int i = 0 ; i < output.length; i++){
			System.out.print(output[i]+" ");
		}
		
	}
}
