import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {
    private Map<Vertex, List<WeightedEdge>> adjacencyMap;

    public WeightedGraph() {
        adjacencyMap = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        adjacencyMap.put(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex source, Vertex destination, int weight) {
        List<WeightedEdge> edges = adjacencyMap.get(source);
        edges.add(new WeightedEdge(destination, weight));
    }

    public List<WeightedEdge> getAdjacentEdges(Vertex vertex) {
        return adjacencyMap.get(vertex);
    }

    public List<Vertex> getVertices() {
        return new ArrayList<>(adjacencyMap.keySet());
    }
}
