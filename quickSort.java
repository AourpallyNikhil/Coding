import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nikhilaourpally on 9/2/15.
 */

public class Test {

    public static void swap(int [] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    public static int partition(int [] inputArray, int start, int end){
        int pivotIndex = end;
        int index = start;

        //Find an element which smaller than the pivot
        for(int i = start ; i < end; i++){
            if(inputArray[i] <= inputArray[pivotIndex]){
                // Swap the element smaller than the pivot with the element at the 'index' position
                swap(inputArray, index,i);
                index++;
            }
        }
        swap(inputArray, index, pivotIndex);
        return index;
    }


    public static void quickSort(int [] input, int start, int end){
        if(start < end){
            int pivotIndex = partition(input, start, end);
            for(int p = 0; p < input.length; p++){
                System.out.print(input[p] + " ");
            }
            System.out.println();
            quickSort(input, start, pivotIndex - 1);
            quickSort(input, pivotIndex + 1, end);
        }
    }


    public static void main(String [] args){
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            int noOfTestCases = Integer.parseInt(bufferRead.readLine());
            int counter = 0;
            String input = bufferRead.readLine();
            String [] strArray = input.split(" ");
            int [] intArray = new int[noOfTestCases];

            for(String s: strArray){
                intArray[counter++] = Integer.parseInt(s);
            }

            quickSort(intArray, 0, intArray.length - 1);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
