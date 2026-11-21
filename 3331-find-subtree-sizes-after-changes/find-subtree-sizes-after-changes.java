class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    int[] size;
    int[] last;
    int[] parent;
    String s;
    public void dfs(int node) {
        int c = s.charAt(node) - 'a';
        int closest = last[c];
        last[c] = node;
        for (int child : adj.getOrDefault(node, Collections.emptyList())) {
            dfs(child);
        }
        last[c] = closest;
        if (node != 0) {
            if (closest != -1) {
                parent[node] = closest;
                size[closest] += size[node];
            } else {
                size[parent[node]] += size[node];
            }
        }
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        this.s = s;
        this.parent = parent;
        int n = parent.length;
        for (int i=1; i<n; i++) {
            int u = parent[i];
            int v = i;
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        size = new int[n];
        Arrays.fill(size, 1);
        last = new int[26];
        Arrays.fill(last, -1);
        dfs(0);
        return size;
    }
}