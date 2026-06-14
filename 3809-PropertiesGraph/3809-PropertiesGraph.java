// Last updated: 6/14/2026, 10:04:44 AM
class Solution {
    static int[] parent, size;
    static int components;
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
            return;
        }
        if (size[pu] > size[pv]) {
            size[pu] += size[pv];
            parent[pv] = pu;
        } else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }
        components--;
    }
    public int intersect(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<b.length; j++) {
                if (a[i] == b[j] && !set.contains(a[i])) {
                    set.add(a[i]);
                    break;
                }
            }
        }
        return set.size();
    }
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        int m = properties[0].length;
        components = n;
        parent = new int[n];
        size = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int in = intersect(properties[i], properties[j]);
                if (in >= k) {
                    union(i, j);
                }
            }
        }
        return components;
    }
}