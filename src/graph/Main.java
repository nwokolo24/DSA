package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph.putIfAbsent(x, new ArrayList<>());
            graph.get(x).add(y);
        }

        // If graph is undirected, then uncomment the code below
//        for (int[] edge : edges) {
//            int x = edge[0], y = edge[1];
//            graph.putIfAbsent(y, new ArrayList<>());
//            graph.get(y).add(x);
//        }

        return graph;
    }
}

class GraphTreeNode {
    int data;
    List<Integer> neighbors;

    public GraphTreeNode(int data) {
        this.data = data;
    }
}
