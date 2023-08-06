import java.util.*;

public class BreadthFirstSearch {
    private WeightedGraph graph;
    private Vertex start;

    public BreadthFirstSearch(WeightedGraph graph, Vertex start) {
        this.graph = graph;
        this.start = start;
    }

    public List<Vertex> bfs() {
        List<Vertex> result = new ArrayList<>();
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            result.add(current);

            for (WeightedEdge edge : graph.getAdjacentEdges(current)) {
                Vertex neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return result;
    }
}
