package harmo.projects.graphs;

public class Graph {

    private int V; //number of vertices in the graph
    private int E; //number of edges in graph.
    private int[][] adjMatrix;

    public Graph(int nodes) {
        this.V = nodes;
        this.E = 0;
        adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;//because it is an undirected graph.
        E++;
    }
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        System.out.println(graph);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices, ").append(E).append(" edges\n");
        for(int v = 0; v < V ; v++){
            sb.append(v).append(": ");
            for(int w: adjMatrix[v]){
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
