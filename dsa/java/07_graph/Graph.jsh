import java.util.ArrayList;
import java.util.HashMap;

    public class Graph {

        private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

        // Vertex Operations
        public boolean addVertex(String vertex) {
            if (hasVertex(vertex)) {
                return false;
            }
            adjList.put(vertex, new ArrayList<>());
            return true;
        }

        public boolean removeVertex(String vertex) {
            if (!hasVertex(vertex)) {
                return false;
            }
            for (String neighbor : adjList.get(vertex)) {
                adjList.get(neighbor).remove(vertex);
            }
            adjList.remove(vertex);
            return true;
        }

        // New Method: hasVertex
        public boolean hasVertex(String vertex) {
            return adjList.containsKey(vertex);
        }

        // Edge Operations
        public boolean addEdge(String src, String dest) {
            if (!hasVertex(src) || !hasVertex(dest)) {
                return false;
            }
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
            return true;
        }

        public void addEdgeWithVertex(String src, String dest) {
            if (!hasVertex(src)) {
                addVertex(src);
            }
            if (!hasVertex(dest)) {
                addVertex(dest);
            }
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        public boolean removeEdge(String src, String dest) {
            if (!hasVertex(src) || !hasVertex(dest)) {
                return false;
            }
            adjList.get(src).remove(dest);
            adjList.get(dest).remove(src);
            return true;
        }

        public void printGraph() {
            for (String vertex : adjList.keySet()) {
                System.out.print(vertex + " -> ");
                System.out.println(adjList.get(vertex));
            }
        }
    }