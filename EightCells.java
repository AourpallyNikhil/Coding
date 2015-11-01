package amcat;

public class EightCells {

	public static void main(String[] args){
		int[] eight = {1,1,1,0,1,1,1,1};
		int[] eightCopy = new int[8];
		int days  = 2;
		for(int t = 0 ; t < 8; t++){
			eightCopy[t] = eight[t];
		}
		
		for(int i = 0; i < days; i++){
			for(int j = 0; j < eightCopy.length; j++){
				if(j == 0){
					if(eightCopy[j+1] == 0){
						eight[j] = 0;
					}else{
						eight[j] = 1;
					}
				}else if(j == eightCopy.length -1){
					if(eightCopy[j-1] == 0){
						eight[j] = 0;
					}else{
						eight[j] = 1;
					}
				}else{
					if((eightCopy[j-1] == 0 && eightCopy[j+1] == 0) || (eightCopy[j-1] == 1 && eightCopy[j+1] == 1)){
						eight[j] = 0;
					}else{
						eight[j] = 1;
					}
				}
			}
			for(int n = 0 ; n < 8; n++){
				eightCopy[n] = eight[n];
			}
		}
	
		for(int out = 0; out < 8; out++){
			System.out.print(eight[out]+ " ");
		}
	}
}
