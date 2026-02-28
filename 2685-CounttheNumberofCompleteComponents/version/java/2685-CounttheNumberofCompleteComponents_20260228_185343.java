// Last updated: 2/28/2026, 6:53:43 PM
1class Solution {
2    static int[] parent;
3    static int[] size;
4    static int[] edgeCount;
5    public int find(int x) {
6        if (x == parent[x]) {
7            return x;
8        }
9        return parent[x] = find(parent[x]);
10    }
11    public void union(int u, int v) {
12        int pu = find(u);
13        int pv = find(v);
14        if (pu == pv) {
15            edgeCount[pu]++;
16            return;
17        }
18        if (size[pu] > size[pv]) {
19            size[pu] += size[pv];
20            parent[pv] = pu;
21            edgeCount[pu] += edgeCount[pv] + 1;
22        } else {
23            size[pv] += size[pu];
24            parent[pu] = pv;
25            edgeCount[pv] += edgeCount[pu] + 1;
26        }
27    }
28    public int countCompleteComponents(int n, int[][] edges) {
29        parent = new int[n];
30        size = new int[n];
31        edgeCount = new int[n];
32        for (int i=0; i<n; i++) {
33            parent[i] = i;
34            size[i] = 1;
35        }
36        for (int[] edge : edges) {
37            union(edge[0], edge[1]);
38        }
39        int complete = 0;
40        for (int i=0; i<n; i++) {
41            if (i == parent[i]) {
42                int nodes = size[i];
43                int expectedCount = nodes * (nodes-1) / 2;
44                if (expectedCount == edgeCount[i]) {
45                    complete++;
46                }
47            }
48        }
49        return complete;
50    }
51}