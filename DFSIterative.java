package Graphs;

import java.util.LinkedList;
import java.util.*;

public class DFSIterative{	
	int[][] graph;
	int rootNode;
	Stack<Integer> stack;
	
	DFSIterative(int[][] inputGraph, int rootNode){
		stack = new Stack();
		this.rootNode = rootNode;
		graph = new int[inputGraph.length][inputGraph[0].length];
		stack.push(rootNode);
		for(int a = 0; a < inputGraph.length; a++){
			for(int b = 0; b < inputGraph[0].length; b++){
				graph[a][b] = inputGraph[a][b];
			}
		}
	}
	public List<Integer> doDFS(){
		int flag;
		List<Integer> result = new ArrayList<Integer>();
		result.add(rootNode);
		while(!stack.isEmpty()){
			flag = -1;
			int root = stack.peek();
			for(int i = 0; i < graph[0].length; i++){
				if(graph[root][i] == 1 && !result.contains(i)){
					result.add(i);
					flag = 1;
				}
			}
			if(flag == -1){
				stack.pop();
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		int root = 2;
		int[][] input = {{0, 1, 1},
						 {1, 0, 1},
						 {1, 1, 0}};
		
		DFSIterative test = new DFSIterative(input, root);
		System.out.println(test.doDFS());
	}
}
