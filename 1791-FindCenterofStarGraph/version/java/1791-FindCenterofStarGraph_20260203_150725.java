// Last updated: 2/3/2026, 3:07:25 PM
1class Solution {
2    public int findCenter(int[][] edges) {
3        int n = edges.length + 1;
4        int[] arr = new int[n+1];
5        for (int i=0; i<n-1; i++) {
6            int u = edges[i][0];
7            int v = edges[i][1];
8            arr[u]++;
9            arr[v]++;
10        }
11        for (int i=1; i<=n; i++) {
12            if (arr[i] == n-1) {
13                return i;
14            }
15        }
16        return -1;
17    }
18}