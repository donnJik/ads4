import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addEdge(v1, v2, 3);
        graph.addEdge(v1, v3, 2);
        graph.addEdge(v2, v4, 5);
        graph.addEdge(v3, v4, 1);

        System.out.println("BFS traversal:");
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, v1);
        List<Vertex> bfsResult = bfs.bfs();
        for (Vertex vertex : bfsResult) {
            System.out.println(vertex.getId());
        }

        System.out.println("Dijkstra's algorithm:");
        DijkstraSearch dijkstra = new DijkstraSearch(graph, v1);
        Map<Vertex, Integer> distances = dijkstra.dijkstra();
        for (Vertex vertex : distances.keySet()) {
            System.out.println("Distance to vertex " + vertex.getId() + ": " + distances.get(vertex));
        }
    }
}
