package example.persistent;

import java.util.*;

class A8DirectedAcyclicGraph {
    private final int numVertices;
    private final List<List<Integer>> adjList;

    public A8DirectedAcyclicGraph(int numVertices) {
        if (numVertices <= 0) throw new IllegalArgumentException("Number of vertices must be positive");
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
    }

    public void generateRandomDAG(int numEdges) {
        if (numEdges < 0) throw new IllegalArgumentException("Number of edges cannot be negative");

        // Maximum possible edges in a DAG: n * (n-1) / 2
        int maxEdges = numVertices * (numVertices - 1) / 2;
        if (numEdges > maxEdges) {
            throw new IllegalArgumentException("Too many edges for a DAG with " + numVertices + " vertices. Max: " + maxEdges);
        }

        // Generate all possible edges (source < destination to ensure no cycles)
        List<int[]> possibleEdges = new ArrayList<>();
        for (int source = 0; source < numVertices; source++) {
            for (int destination = source + 1; destination < numVertices; destination++) {
                possibleEdges.add(new int[]{source, destination});
            }
        }

        // Shuffle the edges to randomize
        Collections.shuffle(possibleEdges, new Random());

        // Add the first numEdges edges
        for (int i = 0; i < numEdges; i++) {
            int[] edge = possibleEdges.get(i);
            addEdge(edge[0], edge[1]);
        }
    }

    // Optional: Method to check if the graph is a DAG (for validation if using a different edge generation method)
    public boolean isDAG() {
        boolean[] visited = new boolean[numVertices];
        boolean[] recStack = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                if (hasCycle(i, visited, recStack)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(int vertex, boolean[] visited, boolean[] recStack) {
        visited[vertex] = true;
        recStack[vertex] = true;

        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, visited, recStack)) return true;
            } else if (recStack[neighbor]) {
                return true; // Cycle detected
            }
        }
        recStack[vertex] = false;
        return false;
    }

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
        int numVertices = 5;
        int numEdges = 7;

        try {
            A8DirectedAcyclicGraph dag = new A8DirectedAcyclicGraph(numVertices);
            dag.generateRandomDAG(numEdges);
            System.out.println("Generated DAG:");
            dag.printGraph();
            System.out.println("Is DAG: " + dag.isDAG());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}