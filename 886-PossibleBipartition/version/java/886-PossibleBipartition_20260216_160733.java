// Last updated: 2/16/2026, 4:07:33 PM
1class Solution {
2    public boolean possibleBipartition(int n, int[][] dislikes) {
3        int[] teams = new int[n+1];
4        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
5        for (int i=0; i<=n; i++) {
6            adjlist.add(new ArrayList<>());
7        }
8        for (int[] edge : dislikes) {
9            int u = edge[0];
10            int v = edge[1];
11            adjlist.get(u).add(v);
12            adjlist.get(v).add(u);
13        }
14        Queue<Integer> q = new LinkedList<>();
15        for (int i=1; i<=n; i++) {
16            if (teams[i] == 0) {
17                q.offer(i);
18                teams[i] = 1;
19                while (!q.isEmpty()) {
20                    int cur = q.poll();
21                    for (int neighbor : adjlist.get(cur)) {
22                        if (teams[neighbor] == 0) {
23                            q.offer(neighbor);
24                            teams[neighbor] = 3 - teams[cur];
25                        } else if (teams[neighbor] == teams[cur]) {
26                            return false;
27                        }
28                    }
29                }
30            }
31        }
32        return true;
33    }
34}