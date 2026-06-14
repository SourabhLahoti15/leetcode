// Last updated: 6/14/2026, 10:04:23 AM
class Solution {
    int[] parent;
    int[] size;
    int[] parity;
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        int p = parent[x];
        parent[x] = find(parent[x]);
        parity[x] = parity[x] ^ parity[p];
        return parent[x];
    }
    public int numberOfEdgesAdded(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        parity = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
            parity[i] = 0;
        }
        int count = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int pu = find(u);
            int pv = find(v);
            if (pu != pv) {
                if (size[pu] < size[pv]) {
                    parent[pu] = pv;
                    size[pv] += size[pu];
                    parity[pu] = parity[u] ^ parity[v] ^ w;
                } else {
                    parent[pv] = pu;
                    size[pu] += size[pv];
                    parity[pv] = parity[u] ^ parity[v] ^ w;
                }
                count++;
            } else {
                if ((parity[u] ^ parity[v]) == w) {
                    count++;
                }
            }
        }
        return count;
    }
}