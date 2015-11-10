package test;

import java.util.*;

public class DFS {
	int[][] graph;
	int rootNode;
	List<Integer> visitedList;
	
	DFS(int[][] input, int root){
		graph = new int[input.length][input[0].length];
		for(int a = 0; a < input.length; a++){
			for(int b = 0; b < input[0].length; b++){
				graph[a][b] = input[a][b];
			}
		}
		rootNode = root;
		visitedList = new ArrayList<Integer>();
	}
	
	public void doDFS(int rootNode){
		visitedList.add(rootNode);
		for(int j = 0; j < graph[0].length; j++){
			if(!visitedList.contains(j)){
				doDFS(j);
			}
		}		
	}
	
	public static void main(String[] args){
		int root = 2;
		int[][] input = {{0, 1, 1},
						 {1, 0, 1},
						 {1, 1, 0}};	
		
		DFS test = new DFS(input, root);
		test.doDFS(root);
		System.out.println(test.visitedList);
	}
}
