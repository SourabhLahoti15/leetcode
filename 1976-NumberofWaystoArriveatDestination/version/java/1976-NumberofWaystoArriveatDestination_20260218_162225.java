// Last updated: 2/18/2026, 4:22:25 PM
1class Solution {
2    class Pair {
3        int node;
4        long time;
5
6        Pair(int node, long time) {
7            this.node = node;
8            this.time = time;
9        }
10    }
11    static final int MOD = 1_000_000_007;
12    public int countPaths(int n, int[][] roads) {
13        ArrayList<ArrayList<Pair>> adjlist = new ArrayList<>();
14        for (int i=0; i<n; i++) {
15            adjlist.add(new ArrayList<>());
16        }
17        for (int i=0; i<roads.length; i++) {
18            int u = roads[i][0];
19            int v = roads[i][1];
20            int time = roads[i][2];
21            adjlist.get(u).add(new Pair(v, time));
22            adjlist.get(v).add(new Pair(u, time));
23        }
24        int[] ways = new int[n];
25        ways[0] = 1;
26        long[] time = new long[n];
27        Arrays.fill(time, Long.MAX_VALUE);
28        time[0] = 0;
29        PriorityQueue<Pair> pq = new PriorityQueue<>(
30            (a, b) -> Long.compare(a.time, b.time)
31        );
32        pq.offer(new Pair(0, 0));
33        while (!pq.isEmpty()) {
34            Pair cur = pq.poll();
35            int u = cur.node;
36            long utime = cur.time;
37            if (utime > time[u]) continue;
38            for (Pair neighbor : adjlist.get(u)) {
39                int v = neighbor.node;
40                long vtime = neighbor.time;
41                if (utime + vtime < time[v]) {
42                    ways[v] = ways[u];
43                    time[v] = utime + vtime;   
44                    pq.offer(new Pair(v, time[v]));
45                } else if (utime + vtime == time[v]) {
46                    ways[v] = (ways[v] + ways[u])%MOD;
47                }
48            }
49        }
50        return ways[n-1];
51    }
52}