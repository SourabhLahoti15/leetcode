// Last updated: 2/4/2026, 9:45:06 AM
1class Solution {
2    public boolean validPath(int n, int[][] edges, int source, int destination) {
3        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
4        for (int i=0; i<n; i++) {
5            adjlist.add(new ArrayList<>());
6        }
7        for (int i=0; i<edges.length; i++) {
8            int u = edges[i][0];
9            int v = edges[i][1];
10            adjlist.get(u).add(v);
11            adjlist.get(v).add(u);
12        }
13
14        Queue<Integer> q = new LinkedList<>();
15        boolean[] visited = new boolean[n];
16
17        visited[source] = true;
18        q.add(source);
19
20        while (!q.isEmpty()) {
21            int cur = q.poll();
22            for (int neighbour : adjlist.get(cur)) {
23                if (!visited[neighbour]) {
24                    visited[neighbour] = true;
25                    q.offer(neighbour);
26                }
27            }
28        }
29        return visited[destination];
30    }
31}