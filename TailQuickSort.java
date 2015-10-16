
public class TailQuickSort {
	public static void swap(int arr[], int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static int partition(int a [], int first, int last){
		int wall = first;
		int pivot = last;
		
		for(int i = first; i <= last; i++){
			if(a[i] < a[pivot]){
				swap(a, i, wall);
				wall++;
			}			
		}
		swap(a,pivot, wall);
		
		return wall;
	}
	
	public static void TailQuickSort(int a[], int first, int last){	
		while(first < last){
			int pivotIndex = partition(a, first, last);
			TailQuickSort(a, first, pivotIndex - 1);
			first = pivotIndex + 1;
		}
	}
	
	public static void main(String []args){
		int a [] = {5,4,3,1,7,8,9,10};
		int firstIndex = 0;
		int lastIndex = a.length - 1;
		TailQuickSort(a, firstIndex, lastIndex);
		for(int each :a ){
			System.out.print(each+" ");
		}
	}
}
