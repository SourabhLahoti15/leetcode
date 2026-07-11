class Solution {
    static int[] parent;
    static int[] size;
    static int[] edgeCount;
    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            edgeCount[pu]++;
            return;
        }
        if (size[pu] > size[pv]) {
            size[pu] += size[pv];
            parent[pv] = pu;
            edgeCount[pu] += edgeCount[pv] + 1;
        } else {
            size[pv] += size[pu];
            parent[pu] = pv;
            edgeCount[pv] += edgeCount[pu] + 1;
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        edgeCount = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        int complete = 0;
        for (int i=0; i<n; i++) {
            if (i == parent[i]) {
                int nodes = size[i];
                int expectedCount = nodes * (nodes-1) / 2;
                if (expectedCount == edgeCount[i]) {
                    complete++;
                }
            }
        }
        return complete;
    }
}