import java.util.*;

public class DijkstraSearch {
    private WeightedGraph graph;
    private Vertex start;

    public DijkstraSearch(WeightedGraph graph, Vertex start) {
        this.graph = graph;
        this.start = start;
    }

    public Map<Vertex, Integer> dijkstra() {
        Map<Vertex, Integer> distances = new HashMap<>();
        PriorityQueue<WeightedEdge> minHeap = new PriorityQueue<>(Comparator.comparingInt(WeightedEdge::getWeight));
        Set<Vertex> visited = new HashSet<>();

        for (Vertex vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }

        distances.put(start, 0);
        minHeap.add(new WeightedEdge(start, 0));

        while (!minHeap.isEmpty()) {
            WeightedEdge edge = minHeap.poll();
            Vertex current = edge.getDestination();
            if (visited.contains(current)) {
                continue;
            }

            visited.add(current);

            for (WeightedEdge neighborEdge : graph.getAdjacentEdges(current)) {
                Vertex neighbor = neighborEdge.getDestination();
                int newDistance = distances.get(current) + neighborEdge.getWeight();
                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    minHeap.add(new WeightedEdge(neighbor, newDistance));
                }
            }
        }

        return distances;
    }
}
