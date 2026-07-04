class Solution {
    public int minScore(int n, int[][] roads) {
        HashMap<Integer, List<int[]>> hmap = new HashMap<>();
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];
            if (!hmap.containsKey(u)) hmap.put(u, new ArrayList<>());
            hmap.get(u).add(new int[]{ v, dist });
            if (!hmap.containsKey(v)) hmap.put(v, new ArrayList<>());
            hmap.get(v).add(new int[]{ u, dist });
        }
        int ans = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(1);
        visited.add(1);
        while (!q.isEmpty()) {
            int u = q.poll();
            List<int[]> neighbours = hmap.get(u);
            for (int[] neighbour : neighbours) {
                ans = Math.min(ans, neighbour[1]);
                if (!visited.contains(neighbour[0])) {
                    q.offer(neighbour[0]);
                    visited.add(neighbour[0]);
                } 
            }
        }
        return ans;
    }
}