package graph;

public class UserInterface {

	public static void main(String[] args) {
		int nodes = 10;
		//int edges = 15;
		Graph graph = new Graph(nodes);
		graph.addEdge(0, 1,1); 
		graph.addEdge(0, 9,1); 
		graph.addEdge(1, 2,1); 
		graph.addEdge(1, 8,1); 
		graph.addEdge(1, 9,1); 
		graph.addEdge(2, 3,1); 
		graph.addEdge(2, 7,1);
		graph.addEdge(2, 8,1);
		graph.addEdge(3, 4,1);
		graph.addEdge(3, 6,1);
		graph.addEdge(3, 7,1);
		graph.addEdge(4, 5,1);
		graph.addEdge(4, 6,1);
		graph.addEdge(5, 6,1);
		graph.addEdge(6, 7,1);
		graph.addEdge(7, 8,1);
		graph.addEdge(8, 9,1);
		graph.viewGraph(graph);
		System.out.println("------Shortest Path------");
        graph.dijkstraAlgorithm(0, graph);
	}

}
