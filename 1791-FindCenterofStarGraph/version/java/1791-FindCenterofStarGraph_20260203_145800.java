// Last updated: 2/3/2026, 2:58:00 PM
1class Solution {
2    public int findCenter(int[][] edges) {
3        int n = edges.length + 1;
4        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
5        for (int i=0; i<=n; i++) {
6            adjlist.add(new ArrayList<>());
7        }
8        for (int i=0; i<n-1; i++) {
9            int u = edges[i][0];
10            int v = edges[i][1];
11            adjlist.get(u).add(v);
12            adjlist.get(v).add(u);
13        }
14        for (int i=1; i<=n; i++) {
15            if (adjlist.get(i).size() != 1) {
16                return i;
17            }
18        }
19        return -1;
20    }
21}