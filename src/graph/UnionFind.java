package graph;

public class UnionFind {
    private int[] root;
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    // Optimizing find method using path compression
    public int find(int x) {
        if (x == root[x]) return x;

        return root[x] = find(root[x]);
    }

    // Quick Find approach
    public int quickFind(int x) {
        return root[x];
    }
    public void unionOfQuickFind(int x, int y) {
        int rootX = quickFind(x);
        int rootY = quickFind(y);

        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY)
                    root[i] = rootX;
            }
        }
    }
    public boolean quickFindConnected(int x, int y) {
        return quickFind(x) == quickFind(y);
    }

    // Quick Union approach
    public int quickUnionFind(int x) {
        while (x != root[x])
            x = root[x];
        return x;
    }
    public void unionOfQuickUnion(int x, int y) {
        int unionX = find(x);
        int unionY = find(y);

        if (unionY != unionX) {
            root[unionY] = unionX;
        }
    }
    public boolean quickUnionConnected(int x, int y) {
        return quickUnionFind(x) == quickUnionFind(y);
    }

    // Quick Union by Rank
    public void unionByRank(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
