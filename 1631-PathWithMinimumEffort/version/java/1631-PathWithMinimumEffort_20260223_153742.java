// Last updated: 2/23/2026, 3:37:42 PM
1class Solution {
2    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
3        ArrayList<ArrayList<double[]>> adj = new ArrayList<>();
4        for (int i = 0; i < n; i++) {
5            adj.add(new ArrayList<>());
6        }
7        for (int i=0; i<edges.length; i++) {
8            int u = edges[i][0];
9            int v = edges[i][1];
10            adj.get(u).add(new double[] { v, succProb[i] });
11            adj.get(v).add(new double[] { u, succProb[i] });
12        }
13        double[] prob = new double[n];
14        prob[start_node] = 1.0;
15        PriorityQueue<double[]> pq = new PriorityQueue<>(
16                (a, b) -> Double.compare(b[1], a[1]));
17        pq.offer(new double[] { start_node, 1 });
18        while (!pq.isEmpty()) {
19            double[] cur = pq.poll();
20            int u = (int) cur[0];
21            double uprob = cur[1];
22            if (u == end_node) {
23                return uprob;
24            }
25            for (double[] nei : adj.get((int)u)) {
26                int v = (int) nei[0];
27                double vprob = uprob * nei[1];
28                if (vprob > prob[v]) {
29                    prob[v] = vprob;
30                    pq.offer(new double[] { v, vprob });
31                }
32            }
33        }
34        return 0;
35    }
36}