import graph.UnionFind;
import hashtable.MyHashTable;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
//        UnionFind uf = new UnionFind(10);
//        // 1-2-5-6-7 3-8-9 4
//        uf.unionByRank(1, 2);
//        uf.unionByRank(2, 5);
//        uf.unionByRank(5, 6);
//        uf.unionByRank(6, 7);
//        uf.unionByRank(3, 8);
//        uf.unionByRank(8, 9);
//        System.out.println(uf.quickUnionConnected(1, 5)); // true
//        System.out.println(uf.quickUnionConnected(5, 7)); // true
//        System.out.println(uf.quickUnionConnected(4, 9)); // false
//        // 1-2-5-6-7 3-8-9-4
//        uf.unionByRank(9, 4);
//        System.out.println(uf.quickUnionConnected(4, 9)); // true


//        // Converting 2D arrays to 1D array
//        int[][] grid = {{1, 2, 3},
//                        {4, 5, 6},
//                        {7, 8, 9}};
//        int m = grid.length;
//        int n = grid[0].length;
//
//        int[] oneDimension = new int[m * n];
//
//        // Row-Major order
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int k = j + i * n;
//                oneDimension[k] = grid[i][j];
//            }
//        }
//        System.out.println(Arrays.deepToString(grid));
//        System.out.println("Row Major Order.");
//        System.out.println(Arrays.toString(oneDimension));
//
//        System.out.println();
//        // Col-Major order
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int k = i + j * n;
//                oneDimension[k] = grid[i][j];
//            }
//        }
//        System.out.println("Column Major Order.");
//        System.out.println(Arrays.toString(oneDimension));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(7);
        maxHeap.add(1);
        maxHeap.add(9);
        PriorityQueue<Integer> heapWithValues = new PriorityQueue<>(Arrays.asList(3,1,2));

//        System.out.println(heapWithValues);
//        System.out.println(maxHeap);
//        maxHeap.poll();
//        System.out.println(maxHeap);


        MyHashTable map = new MyHashTable(10);
        map.put(34, "Formula");
        map.put(2, "Labrinth");

        System.out.println(map.get(2));
    }
}