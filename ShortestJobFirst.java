
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Nikhil
 *
 *A program which returns the average waiting time of the jobs using Shortest Job First Scheduling 
 
 */

public class SJF{
	
	public static float doSJF(int[] startTimes, int[] Durations){
		int timer = 0;
		int flag = -1;
		Queue<Integer> proc = new LinkedList<Integer>();
		List<Integer> waiting = new ArrayList<Integer>();
		int waitingTime = 0;
		
		for(int i = 0; i < startTimes.length; i++){
			proc.add(i);
		}
		
		waiting.add(0);
		while(!proc.isEmpty() || !waiting.isEmpty()){
			if(flag == -1){
				timer = timer+ Durations[proc.remove()];
				waiting.remove(0);
				flag = 0;
			}

			//Add all the process to the waiting list whose start time is less the timer
			while(proc.peek() != null && startTimes[proc.peek()] <= timer){
				waiting.add(proc.remove());
			}
			 
			//get the index of the shortest job index
			if(!waiting.isEmpty()){				
				int shortestJobIndex = getSmallestJob(waiting, startTimes, Durations);
				waiting.remove(new Integer(shortestJobIndex));
				waitingTime = waitingTime + (timer - startTimes[shortestJobIndex]);
				timer = timer + Durations[shortestJobIndex];
			}
		}

		return (float)waitingTime/startTimes.length;
	}
	
	public static int getSmallestJob(List<Integer> waiting, int[] startTimes, int[] Durations){
		int min = waiting.get(0);
		for(int each : waiting){
			if(Durations[min] > Durations[each]){
				min = each;
			}
		}
		return min;	
	}
	
	
	public static void main(String[] args){
		int[] startTime = {0,2,4,6,8,11};
		int[]  Durations = {9,7,5,4,3,2};
		float result = doSJF(startTime, Durations);
		System.out.println(result);
	}
}
