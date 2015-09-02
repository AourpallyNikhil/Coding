import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by nikhilaourpally on 9/2/15.
 */

public class Test {

    public static void jobSchedule(int [] input1, int [] input2){
         int [] startTime = input1;
         int [] finishTime = input2;
         ArrayList <Integer> output = new ArrayList<Integer>();
         HashMap<Integer,Integer> finishStart= new HashMap<Integer,Integer>();

         for(int k = 0; k < input1.length; k++){
            finishStart.put(input2[k], input1[k]);
         }

         Arrays.sort(finishTime);

         int currentFinishTime = finishTime[0];
         for(int i = 1 ; i < finishTime.length; i++){
            if(finishStart.get(finishTime[i]) > currentFinishTime){

                output.add(startTime[i]);
                currentFinishTime = finishTime[i];
            }
         }

        if(output.isEmpty()){
            System.out.println("Not compatible");
        }else{
            System.out.println(finishStart.get(finishTime[0]));
            for(int s : output){
                System.out.println(s);
            }
        }
    }


    public static void main(String [] args){
        int [] a = {1, 3, 8, 11};
        int [] b = {5, 7, 10, 13};
        jobSchedule(a, b);
    }
}
