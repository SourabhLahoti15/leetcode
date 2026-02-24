// Last updated: 2/24/2026, 2:29:56 PM
1class Solution {
2    static int[] parent;
3    static int[] size;
4    public int find(int x) {
5        if (x == parent[x]) {
6            return x;
7        }
8        return parent[x] = find(parent[x]);
9    }
10    public boolean union(int u, int v) {
11        int uparent = find(u);
12        int vparent = find(v);
13        if (uparent == vparent) {
14            return true;
15        }
16        if (size[uparent] > size[vparent]) {
17            parent[vparent] = uparent;
18            size[uparent] += size[vparent];
19        } else {
20            parent[uparent] = vparent;
21            size[vparent] += size[uparent];
22        }
23        return false;
24    }
25    public int[] findRedundantConnection(int[][] edges) {
26        int n = edges.length;
27        parent = new int[n+1];
28        size = new int[n+1];
29        for (int i=0; i<=n; i++) {
30            parent[i] = i;
31            size[i] = 1;
32        }
33        for (int[] edge : edges) {
34            int u = edge[0];
35            int v = edge[1];
36            if (union(u, v)) {
37                return new int[]{u, v};
38            }
39        }
40        return new int[]{-1, -1};
41    }
42}