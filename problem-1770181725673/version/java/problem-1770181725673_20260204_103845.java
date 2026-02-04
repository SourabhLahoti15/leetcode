// Last updated: 2/4/2026, 10:38:45 AM
1class Solution {
2    public int findCircleNum(int[][] isConnected) {
3        int n = isConnected.length;
4        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
5        for (int i=0; i<n; i++) {
6            adjlist.add(new ArrayList<>());
7        }
8        for (int i=0; i<n; i++) {
9            for (int j=0; j<n; j++) {
10                if (isConnected[i][j] == 1) {
11                    if (i == j) continue;
12                    adjlist.get(i).add(j);
13                    adjlist.get(j).add(i);
14                }
15            }
16        }
17        boolean[] visited = new boolean[n];
18        Queue<Integer> q = new LinkedList<>();
19        int count = 0;
20        for (int i=0; i<n; i++) {
21            if (!visited[i]) {
22                visited[i] = true;
23                q.offer(i);
24            } else {
25                continue;
26            }
27            while (!q.isEmpty()) {
28                int cur = q.poll();
29                for (int neighbour : adjlist.get(cur)) {
30                    if (!visited[neighbour]) {
31                        visited[neighbour] = true;
32                        q.offer(neighbour);
33                    }
34                }
35            }
36            count++;
37        }
38        return count;
39    }
40}