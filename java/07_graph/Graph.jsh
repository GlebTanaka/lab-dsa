import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if (adjList.containsKey(vertex)) {
            return false;
        }
        adjList.put(vertex, new ArrayList<>());
        return true;
    }

    public boolean addEdge(String src, String dest) {
        // Check if both vertices exist
        if (!adjList.containsKey(src) || !adjList.containsKey(dest)) {
            return false; // One or both vertices do not exist
        }

        // Add the edge
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
        return true; // Edge successfully added
    }

    public void addEdgeWithVertex(String src, String dest) {
        // Add the vertices if they don't already exist
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());

        // Add the edge
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }
}