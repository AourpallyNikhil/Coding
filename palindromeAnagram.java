import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Print {
	
	static ArrayList<String> permut = new ArrayList<String>();
	
	public static int factorial(int n) {
	       if (n == 0) {
	           return 1;
	       } else {
	           return n * factorial(n - 1);
	       }
	   }

	public static String LCS(String a, String b) {
		String output = "";
        String x = a;
        String y = b;
        int M = x.length();
        int N = y.length();

        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
        int[][] opt = new int[M+1][N+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }

        // recover LCS itself and print it to standard output
        int i = 0, j = 0;
        while(i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
                output = output + x.charAt(i);
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        return opt[0][0] +","+ output;
    }
	
	
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) permut.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	public static Boolean isPalindrome(String s) {
		  int n = s.length();
		  for (int i=0;i<(n / 2) + 1;++i) {
		     if (s.charAt(i) != s.charAt(n - i - 1)) {
		         return false;
		     }
		  }

		  return true;
		}
	
	public static int numofAnagrams(String input){
		int finaloutput = 0;
		HashMap <String, Integer> anagramMap = new HashMap<String, Integer>();
		char [] inputArray = input.toCharArray();
		for(char each : inputArray){
			if(anagramMap.get(Character.toString(each)) == null){
				anagramMap.put(Character.toString(each), 1);
			}else{
				anagramMap.put(Character.toString(each), anagramMap.get(Character.toString(each)) + 1);
			}
		}
		for(String key : anagramMap.keySet()){
			int value = anagramMap.get(key);
			if( value % 2 == 0){
				finaloutput = finaloutput + value/2;
			}
		}
		return factorial(finaloutput);
	}
	
	public static void main (String [] args){
		String input = "aaaaaa";
		if(isPalindrome(input)){
			numofAnagrams(input);
		}else{
			int max = 0;
			String anagramPalindrome = "";
			permutation("",input);
			for(String each : permut){
				String temp = LCS(each, new StringBuilder(each).reverse().toString());
				String [] tempArray = temp.split(",");
				int cur = Integer.parseInt(tempArray[0]);
				if( cur > max){
					max = cur;
					anagramPalindrome = tempArray[1];
				}
			}
			System.out.println(input.length() - anagramPalindrome.length() +","+ numofAnagrams(anagramPalindrome));
			permut.clear();
		}
	}
}

