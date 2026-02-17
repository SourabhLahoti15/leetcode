// Last updated: 2/17/2026, 12:19:38 PM
1class Solution {
2    static class Pair {
3        int node;
4        int dist;
5        Pair(int n, int d) {
6            node = n;
7            dist = d;
8        }
9    }
10    public int networkDelayTime(int[][] times, int n, int k) {
11        ArrayList<ArrayList<Pair>> adjlist = new ArrayList<>();
12        for (int i = 0; i <= n; i++) {
13            adjlist.add(new ArrayList<>());
14        }
15        for (int i = 0; i < times.length; i++) {
16            int[] time = times[i];
17            int u = time[0];
18            int v = time[1];
19            int w = time[2];
20            adjlist.get(u).add(new Pair(v, w));
21        }
22        int[] distance = new int[n + 1];
23        Arrays.fill(distance, Integer.MAX_VALUE);
24        distance[k] = 0;
25        PriorityQueue<Pair> pq = new PriorityQueue<>(
26                (a, b) -> Integer.compare(a.dist, b.dist));
27        pq.add(new Pair(k, 0));
28        while (!pq.isEmpty()) {
29            Pair cur = pq.poll();
30            int u = cur.node;
31            int d = cur.dist;
32            if (d > distance[u])
33                continue;
34            for (Pair neighbor : adjlist.get(u)) {
35                int v = neighbor.node;
36                int w = neighbor.dist;
37                if (distance[u] + w < distance[v]) {
38                    distance[v] = distance[u] + w;
39                    pq.add(new Pair(v, distance[v]));
40                }
41            }
42        }
43        int mintime = 0;
44        for (int i=1; i<=n; i++) {
45            if (distance[i] == Integer.MAX_VALUE) return -1;
46            mintime = Math.max(mintime, distance[i]);
47        }
48        return mintime;
49    }
50}