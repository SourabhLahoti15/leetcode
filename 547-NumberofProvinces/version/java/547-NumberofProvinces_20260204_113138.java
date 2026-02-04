// Last updated: 2/4/2026, 11:31:38 AM
1class Solution {
2    public int findCircleNum(int[][] isConnected) {
3        int n = isConnected.length;
4        boolean[] visited = new boolean[n];
5        Queue<Integer> q = new LinkedList<>();
6        int count = 0;
7        for (int i=0; i<n; i++) {
8            if (visited[i]) {
9                continue;                
10            }
11            visited[i] = true;
12            q.offer(i);
13            while (!q.isEmpty()) {
14                int cur = q.poll();
15                for (int neighbour=0; neighbour<n; neighbour++) {
16                    if (isConnected[cur][neighbour] == 1) {
17                        if (!visited[neighbour]) {
18                            visited[neighbour] = true;
19                            q.offer(neighbour);
20                        }
21                    }
22                }
23            }
24            count++;
25        }
26        return count;
27    }
28}