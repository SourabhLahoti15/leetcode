// Last updated: 6/14/2026, 10:04:43 AM
class Solution {
    int MOD = (int)1e9+7;
    int[] depth;
    HashMap<Integer, List<Integer>> hmap;
    int[][] lift;
    public int power(int base, int exp) {
        long res = 1;
        long b = base % MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = res * b % MOD;
            }
            b = b * b % MOD;
            exp = exp >> 1;
        }
        return (int) res;
    }
    public int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            return lca(v, u);
        }
        int diff = depth[u] - depth[v];
        for (int i=0; i<18; i++) {
            if ((diff & 1) == 1) {
                u = lift[u][i];
            }
            diff = diff >> 1;
        }
        if (u == v) return u;
        for (int j=17; j>=0; j--) {
            if (lift[u][j] != lift[v][j]) {
                u = lift[u][j];
                v = lift[v][j];
            }
        }
        return lift[u][0];
    }
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length+1;
        depth = new int[n+1];
        lift = new int[n + 1][18];
        hmap = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            hmap.putIfAbsent(u, new ArrayList<>());
            hmap.putIfAbsent(v, new ArrayList<>());
            hmap.get(u).add(v);
            hmap.get(v).add(u);
        }
        // BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(1);
        visited[1] = true;
        lift[1][0] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int child : hmap.getOrDefault(cur, new ArrayList<>())) {
                if (!visited[child]) {
                    visited[child] = true;
                    depth[child] = depth[cur] + 1;
                    q.offer(child);
                    lift[child][0] = cur;
                }
            }
        }
        for (int i=1; i<=n; i++) {
            for (int j=1; j<18; j++) {
                lift[i][j] = lift[lift[i][j-1]][j-1];
            }
        }
        int[] ans = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            int dist = depth[u] + depth[v] - 2*depth[lca(u, v)];
            ans[i] = dist == 0 ? 0 : power(2, dist-1);
        }
        return ans;
    }
}