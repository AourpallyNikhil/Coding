
public class DutchPartition {

	public static void swap(char arr[], int a, int b){
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static String partition(char a[], int first, int last, char firstChat, char lastChar){
		String output = "";
		int i = first;
		int j = last;
	    while(i <= j){
	    	while(a[i] != lastChar){
	    		i++;
	    	}
	    	
	    	while(a[j] != firstChat){
	    		j--;
	    	}
	    	if(i <= j){
	    		swap(a, i, j);
	    		i++;
	    		j--;
	    	}
	    }
	    return output = String.valueOf(j)+ ","+ String.valueOf(i); 
	}

	public static void dutchPartition(char a[]){
		int firstIndex = 0;
		int lastIndex = a.length - 1; 
		int middle = (firstIndex + lastIndex)/2; 
		String temp = partition(a,firstIndex, a.length - 1, 'R','B');
		String tempArr[] = temp.split(",");
		partition(a,firstIndex, Integer.parseInt(tempArr[0]), 'R','W');
		partition(a,Integer.parseInt(tempArr[1]), lastIndex, 'W','B');
	}

	public static void main(String []args){
		char a[] = {'W','B','R','R','B','W','R','B','W','R','B','W','R', 'W','W','B','R','R', 'B','R'};
		dutchPartition(a);
        for(int i =0; i < a.length; i++){
        	System.out.print(a[i] + " ");
        }
	}	
}
ckage test;

