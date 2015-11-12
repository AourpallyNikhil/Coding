package test;

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
		List<Integer> tempList = new ArrayList<Integer>();
		Queue<Integer> proc = new LinkedList<Integer>();
		List<Integer> waiting = new ArrayList<Integer>();
		int waitingTime = 0;
		
		for(int i = 0; i < startTimes.length; i++){
			proc.add(i);
		}
		
		for(int j = 0; j < startTimes.length; j++){
			if(startTimes[j] == startTimes[j+1]){
				tempList.add(new Integer(j));
				tempList.add(new Integer(j+1));
			}else{
				break;
			}
		}
		
		if(!tempList.isEmpty()){
			int shortestIndex = getShortestJob(tempList, startTimes, Durations);
			tempList.remove(new Integer(shortestIndex));
			for(Integer each : tempList){
				proc.remove(new Integer(each));
				waiting.add(new Integer(each));
			}			
		}
		tempList.clear();
		
		while(!proc.isEmpty() || !waiting.isEmpty()){
			if(flag == -1){
				timer = timer+ Durations[proc.remove()];
				flag = 0;
			}

			//Add all the process to the waiting list whose start time is less the timer
			while(proc.peek() != null && startTimes[proc.peek()] <= timer){
				waiting.add(proc.remove());
			}
			
			/*When waiting queue is empty and Processes queue is not empty. When we face this scenario, the we have to
			 * take into consideration the case when two processes arrive at the same time.
			 * 
			 * */ 
			
			if(!proc.isEmpty() && waiting.isEmpty()){
				int top = proc.peek();		
				for(int j = top; j < startTimes.length; j++){
					if(startTimes[j] == startTimes[j+1]){
						tempList.add(new Integer(j));
						tempList.add(new Integer(j+1));
					}else{
						break;
					}
				}
				
				if(!tempList.isEmpty()){
					int shortestIndex = getShortestJob(tempList, startTimes, Durations);
					tempList.remove(new Integer(shortestIndex));
					for(Integer each : tempList){
						proc.remove(new Integer(each));
						waiting.add(new Integer(each));
					}			
				}else{
					int temp = proc.remove();
					timer = startTimes[temp];
					timer = timer + Durations[temp];
				}
			}
			 
			//get the index of the shortest job index
			if(!waiting.isEmpty()){	
				int shortestJobIndex = getShortestJob(waiting, startTimes, Durations);
				waiting.remove(new Integer(shortestJobIndex));
				waitingTime = waitingTime + (timer - startTimes[shortestJobIndex]);
				timer = timer + Durations[shortestJobIndex];
			}
		}
		System.out.println(waitingTime);
		return (float)waitingTime/startTimes.length;
	}
	
	public static int getShortestJob(List<Integer> waiting, int[] startTimes, int[] Durations){
		int min = waiting.get(0);
		for(int each : waiting){
			if(Durations[min] > Durations[each]){
				min = each;
			}
		}
		return min;	
	}
	
	public static void main(String[] args){
		int[] startTime = {0,2,4,8};
		int[]  Durations = {7,3,1,2};
		float result = doSJF(startTime, Durations);
		System.out.println(result);
	}
}