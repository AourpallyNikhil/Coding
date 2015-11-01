package test;

import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin{
	int startTime[];
	int Duration[];
	int sliceTime;
	
	RoundRobin(int[] ST, int[] DR, int slice){
		startTime = ST;
		Duration = DR;
		sliceTime = slice;
	}
	
	public float doRoundRobin(){
		int avgWaitingTime = 0;
		int timer = 0;
		int flag = -1;
		int hold = -1;
		
		Queue<Integer> proc = new LinkedList<Integer>();
		Queue<Integer> waiting = new LinkedList<Integer>();
		
		for(int i = 0; i < startTime.length; i++){
			proc.add(i);
		}
		
		while(!proc.isEmpty() || !waiting.isEmpty()){
			if(flag == -1){
				int firstProc = proc.remove();
				if(Duration[firstProc] <= sliceTime){
					timer = timer + Duration[firstProc];
				}else{
					timer = timer + sliceTime;
					Duration[firstProc] = Duration[firstProc] - sliceTime;
					startTime[firstProc] = timer;
					hold = firstProc;
				}
				flag = 0;
			}

			//Add all the process to the waiting list whose start time is less the timer
			while(proc.peek() != null && startTime[proc.peek()] <= timer){
				waiting.add(proc.remove());
			}
			
			if(hold != -1){
				waiting.add(hold);
				hold = -1;
			}
			
			//When there are no processes in the waiting list.
			if(!proc.isEmpty() && waiting.isEmpty()){
				int temp = proc.remove();
				timer = startTime[temp];
				if(Duration[temp] <= sliceTime){
					timer = timer + Duration[temp];
				}else{
					timer = timer + sliceTime;
					Duration[temp] = Duration[temp] - sliceTime;
					startTime[temp] = timer;
					waiting.add(temp);
				}
			}

			//get the index of the shortest job index
			if(!waiting.isEmpty()){				
				int JobIndex = waiting.remove();
				if(Duration[JobIndex] <= sliceTime){
					avgWaitingTime = avgWaitingTime+ (timer  - startTime[JobIndex]);
					timer = timer + Duration[JobIndex];
				}else{
					avgWaitingTime = avgWaitingTime+ (timer  - startTime[JobIndex]);
					timer = timer + sliceTime;
					Duration[JobIndex] = Duration[JobIndex] - sliceTime;
					startTime[JobIndex] = timer;
					hold = JobIndex;
				}
			}
		}
		
		System.out.println(avgWaitingTime);
		return (float)avgWaitingTime/startTime.length;
	}
	
	public static void main(String[] args){
		int[] startTime = {0,2,4,5};
		int[] Durations = {7,4,1,4};
		int sliceTime = 3;
		RoundRobin test  = new RoundRobin(startTime,Durations, sliceTime);
		System.out.println(test.doRoundRobin());
	}
}
