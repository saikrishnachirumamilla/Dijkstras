package graph;

import java.util.LinkedList;

public class Graph {
	private Integer vertices;
	private int adjacencyMatrix[][];
	private LinkedList<Integer> adjacentList[];

	
	@SuppressWarnings("unchecked")
	public Graph(Integer vertices) {
		this.vertices = vertices;
		adjacencyMatrix = new int [vertices][vertices];
		adjacentList = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacentList[i] = new LinkedList<Integer>();
		}
	}

	public Integer getVertices() {
		return vertices;
	}

	public void setVertices(Integer vertices) {
		this.vertices = vertices;
	}

	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}
	
	public LinkedList<Integer>[] getAdjacentList() {
		return adjacentList;
	}
	public void setAdjacentList(LinkedList<Integer>[] adjacentList) {
		this.adjacentList = adjacentList;
	}
	
	 public void addEdge(int source, int destination, int weight) {
		 adjacencyMatrix[source][destination]=weight;
		 adjacencyMatrix[destination][source] = weight;
		 adjacentList[source].add(destination);
		 adjacentList[destination].add(source);
     }
	 
	 public void viewGraph(Graph graph) {
		for(int vertex = 0; vertex < graph.getVertices(); vertex++) { 
            System.out.println("Adjacency list of vertex "+ vertex); 
            System.out.print(vertex); 
            for(Integer nextVertex: graph.getAdjacentList()[vertex]){ 
                System.out.print(" -> "+nextVertex); 
            } 
            System.out.println("\n"); 
        } 
	 }
	
	 public void dijkstraAlgorithm(int startingPoint, Graph graph) {
		 
		 int [] distances = new int[graph.getVertices()];		 
		 for (int i = 0; i < graph.getVertices(); i++) {
			 distances[i] = Integer.MAX_VALUE;
		 }
		 distances[startingPoint] = 0;
         boolean[] shortestPath = new boolean[graph.getVertices()];

		 for (int i = 0; i < graph.getVertices(); i++) {
			int nextVertex = getNearestNode(graph, distances, shortestPath);
			shortestPath[nextVertex] = true;
			
			for (int j = 0; j < graph.getVertices(); j++) {
				if(adjacencyMatrix[nextVertex][j] > 0) {
					if(shortestPath[j] == false && adjacencyMatrix[nextVertex][j] != Integer.MAX_VALUE) {
						int updatedDistance = adjacencyMatrix[nextVertex][j] + distances[nextVertex];
						if(updatedDistance < distances[j]) {
							distances[j] = updatedDistance;
						}
					}
				}
			}
			
		 }
		 viewShortestPath(graph, startingPoint, distances);
	 }
	 
	 public int getNearestNode(Graph graph, int [] distances, boolean [] shortestPath) {
		 int minimum = Integer.MAX_VALUE;
         int node = -1;
         for (int i = 0; i < graph.getVertices() ; i++) {
             if(shortestPath[i]==false && minimum > distances[i]){
            	 minimum = distances[i];
                 node = i;
             }
         }
         return node;
	 }
	 
	 public void viewShortestPath(Graph graph, int startingPoint, int[] distances) {
		 
		 for (int i = 0; i < graph.getVertices(); i++) {
			System.out.println("Starting vertex: "+startingPoint +" Destination vertex: "+ i+ " Distance: "+ distances[i]);
		}
	 }
}
