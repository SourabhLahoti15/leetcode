// Last updated: 3/1/2026, 5:58:26 PM
1class Solution {
2    static int[] parent, size;
3    static int components;
4    public int find(int x) {
5        if (x == parent[x]) {
6            return x;
7        }
8        return parent[x] = find(parent[x]);
9    }
10    public void union(int u, int v) {
11        int pu = find(u);
12        int pv = find(v);
13        if (pu == pv) {
14            return;
15        }
16        if (size[pu] > size[pv]) {
17            size[pu] += size[pv];
18            parent[pv] = pu;
19        } else {
20            size[pv] += size[pu];
21            parent[pu] = pv;
22        }
23        components--;
24    }
25    public int intersect(int[] a, int[] b) {
26        HashSet<Integer> set = new HashSet<>();
27        for (int i=0; i<a.length; i++) {
28            for (int j=0; j<b.length; j++) {
29                if (a[i] == b[j] && !set.contains(a[i])) {
30                    set.add(a[i]);
31                    break;
32                }
33            }
34        }
35        return set.size();
36    }
37    public int numberOfComponents(int[][] properties, int k) {
38        int n = properties.length;
39        int m = properties[0].length;
40        components = n;
41        parent = new int[n];
42        size = new int[n];
43        for (int i=0; i<n; i++) {
44            parent[i] = i;
45            size[i] = 1;
46        }
47        for (int i=0; i<n; i++) {
48            for (int j=i+1; j<n; j++) {
49                int in = intersect(properties[i], properties[j]);
50                if (in >= k) {
51                    union(i, j);
52                }
53            }
54        }
55        return components;
56    }
57}