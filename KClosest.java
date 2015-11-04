package test;

import java.util.*;

public class KClosest {
	public static void findKClosest(Point[] points, int k){
		PriorityQueue<Double> pq1 = new PriorityQueue<Double>(k, Collections.reverseOrder());
		List<Integer> test = new ArrayList<Integer>();
		HashMap<Double,Point> temp = new HashMap<Double,Point>();
		for(Point each: points){
			double dist = Math.abs(Math.sqrt(Math.pow(each.x, 2)+ Math.pow(each.y, 2)));
			temp.put(dist, each);
			if(pq1.size() < k){
				pq1.add(dist);
			}else if(dist < pq1.peek()){
				pq1.remove();
				pq1.add(dist);
			}
		}	
		for(double each : pq1){
			System.out.print("[ "+ temp.get(each).x + ","+temp.get(each).y+" ]" +" ");
		}
	}
	
	public static void main(String[] args){
		Point[] points = {new Point(1,2), new Point(6,9), new Point(2,3), new Point(7,10), new Point(11,13)};
		int k = 2;
		findKClosest(points, k);
		
	}
}
