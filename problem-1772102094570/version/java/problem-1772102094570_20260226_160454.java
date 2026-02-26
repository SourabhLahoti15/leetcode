// Last updated: 2/26/2026, 4:04:54 PM
1class Solution {
2    static int[] parent;
3    static int[] size;
4    static int components;
5    static int extraEdges;
6    public int find(int x) {
7        if (parent[x] == x) {
8            return x;
9        }
10        return parent[x] = find(parent[x]);
11    }
12    public void union(int u, int v) {
13        int pu = find(u);
14        int pv = find(v);
15        if (pu == pv) {
16            extraEdges++;
17            return;
18        }
19        if (size[pu] > size[pv]) {
20            size[pu] += size[pv];
21            parent[pv] = pu;
22            components--;
23        } else {
24            size[pv] += size[pu];
25            parent[pu] = pv;
26            components--;
27        }
28    }
29    public int makeConnected(int n, int[][] connections) {
30        parent = new int[n];
31        size = new int[n];
32        components = n;
33        extraEdges = 0;
34        for (int i=0; i<n; i++) {
35            parent[i] = i;
36            size[i] = 1;
37        }
38        for (int[] connection : connections) {
39            int u = connection[0];
40            int v = connection[1];
41            union(u, v);
42        }
43        if (extraEdges >= components-1) {
44            return components-1;
45        } else {
46            return -1;
47        }
48    }
49}