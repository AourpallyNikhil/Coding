package test;

import java.util.*;

public class BFS {
	int[][] graph;
	int rootNode;
	Queue<Integer> bfsQueue;
	List<Integer> visitedList;
	
	BFS(int[][] input, int root){
		graph = new int[input.length][input[0].length];
		rootNode = root;	
		for(int a = 0; a < input.length; a++){
			for(int b = 0; b < input[0].length; b++){
				graph[a][b] = input[a][b];
			}
		}
		bfsQueue = new LinkedList<Integer>();
		visitedList = new ArrayList<Integer>();
	}
	
	public void BFS(int rootNode){
		for(int j = 0; j < graph[0].length; j++){
			if(graph[rootNode][j] == 1 && j != rootNode){
				if(!visitedList.contains(j) && !bfsQueue.contains(j)){
					bfsQueue.add(j);
				}
				graph[rootNode][j] = 0;
				graph[j][rootNode] = 0;
			}
		}	
			if(!bfsQueue.isEmpty()){
				int node = bfsQueue.remove();
				visitedList.add(node);
				BFS(node);
			}
	}
	
	public void doBFS(){
		visitedList.add(rootNode);
		BFS(rootNode);
		for(Integer each: visitedList){
			System.out.print(each+ " ");
		}
	}
	
	public static void main(String[] args){
		int root = 2;
		int[][] input = {{0, 1, 1, 0},
						 {1, 0, 1, 1},
						 {1, 1, 0, 1},
						 {0, 1, 0, 0}};		
		
		BFS test = new BFS(input, root);
		test.doBFS();
	}
}
