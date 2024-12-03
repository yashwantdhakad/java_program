package example.persistent;

import java.util.*;

class DirectedAcyclicGraph {
    private final int numVertices;
    private final List<List<Integer>> adjList;

    // Constructor to initialize the DAG
    public DirectedAcyclicGraph(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add a directed edge from source to destination
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
    }

    // Function to generate a random DAG with the given number of edges
    public void generateRandomDAG(int numEdges) {
        Random random = new Random();
        int edgesAdded = 0;

        while (edgesAdded < numEdges) {
            int source = random.nextInt(numVertices);      // Random source node
            int destination = random.nextInt(numVertices); // Random destination node

            // Ensure the edge does not create a cycle and is a valid directed edge
            if (source < destination && !adjList.get(source).contains(destination)) {
                addEdge(source, destination);
                edgesAdded++;
            }
        }
    }

    // Print the adjacency list of the DAG
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int node : adjList.get(i)) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;  // Define the number of nodes (vertices)
        int numEdges = 7;     // Define the number of edges

        DirectedAcyclicGraph dag = new DirectedAcyclicGraph(numVertices);

        // Generate a random DAG
        dag.generateRandomDAG(numEdges);

        // Print the graph's adjacency list
        dag.printGraph();
    }
}

