package Graphs;

import java.util.*;

public class ShortestPathGreedy {
	int[][] graph;
	int[] parents;
	int[] shortestPath;
	List<Integer> vertices = new ArrayList<Integer>();
	int source;
	
	public ShortestPathGreedy(int[][] inputGraph, int source) {
		graph = new int[inputGraph.length][inputGraph[0].length];
		
		for(int a = 0; a < inputGraph.length; a++){
			for(int b = 0; b < inputGraph[0].length; b++){
				graph[a][b] = inputGraph[a][b];
			}
		}
		
		 parents = new int[inputGraph.length];
		 Arrays.fill(parents, -1);
		 
		 shortestPath = new int[inputGraph.length];
		 Arrays.fill(shortestPath, -1); 
		 
		 this.source = source;
		 shortestPath[source] = 0;
		 
		 for(int i = 0; i < inputGraph.length; i++){
			 vertices.add(i); 
		 }
	}

	public int findMinVertex(){
		int min = vertices.get(0);
		for(Integer each: vertices){
			if( shortestPath[each] != -1 && shortestPath[each] < shortestPath[min]){
					min = each;
			}
		}
		vertices.remove(new Integer(min));
		return min;
	}
	/*
	 * Put all vertices in a queue
	 * pick up the vertex with shortest distance from source
	 * Relax it
	 * After relaxing the vertex fix it's distance
	 */
	public int[] findShortestPath(){
		int minVertex;
		while(!vertices.isEmpty()){
			minVertex = findMinVertex();
			relax(minVertex);
//			for(int p = 0 ; p < shortestPath.length; p++){
//				System.out.print(shortestPath[p]+" ");
//			}
			//System.out.println(vertices);
		}
		return shortestPath;
	}
	
	/*
	 * for each adjacent vertex of u 
	 * if(shortestPath[v] == -1) shortestPath[v] = shortestPath[u] + graph[u][v];
	 * else if(shortestPath[v] > shortestPath[u] + graph[u][v]) shortestPath[v] = shortestPath[u] + graph[u][v];   
	 */
	
	public void relax(int u){
		for(int v = 0; v < graph.length; v++){
			if(graph[u][v] != 0){
				if(shortestPath[v] == -1){
					shortestPath[v] = shortestPath[u] + graph[u][v];
				}else if(shortestPath[v] > shortestPath[u] + graph[u][v]){
					shortestPath[v] = shortestPath[u] + graph[u][v];
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[][] input = {{0, -2},
				 		{-2, 0}};
		int source = 0;
		
		ShortestPathGreedy test = new ShortestPathGreedy(input, source);
		int [] output = test.findShortestPath();
		for(int p = 0 ; p < output.length; p++){
			System.out.print(output[p]+" ");
		}
	}
}
