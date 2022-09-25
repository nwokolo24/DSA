package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyList {
    ArrayList<LinkedList<Integer>> adj;
    int V;
    int E;

    public AdjacencyList(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<Integer>());
            }
        }

        public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for (int i = 0; i < V; i++) {
            sb.append(i + ": ");
            for (Integer j : adj.get(i)) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjacencyList adj = new AdjacencyList(4);
        adj.addEdge(0, 1);
        adj.addEdge(1, 2);
        adj.addEdge(2, 3);
        adj.addEdge(3, 0);
        System.out.println(adj);
    }
}
