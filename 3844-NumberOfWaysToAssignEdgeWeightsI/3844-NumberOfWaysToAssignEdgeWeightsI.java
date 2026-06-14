// Last updated: 6/14/2026, 10:04:42 AM
class Solution {
    int MOD = (int)1e9 + 7;
    public int power(int base, int exp) {
        long res = 1;
        long b = base % MOD;
        while (exp > 0) {
            if ((exp&1) == 1) {
                res = res * b%MOD;
            }
            b = b*b%MOD;
            exp = exp >> 1;
        }
        return (int)res;
    }
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            hmap.putIfAbsent(u, new ArrayList<>());
            hmap.putIfAbsent(v, new ArrayList<>());
            hmap.get(u).add(v);
            hmap.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        int depth = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int cur = q.poll();
                for (int child : hmap.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        q.offer(child);
                    }
                }
            }
            depth++;
        }
        return power(2, depth-1);
    }
}