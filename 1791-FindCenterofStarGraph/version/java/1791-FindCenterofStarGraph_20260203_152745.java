// Last updated: 2/3/2026, 3:27:45 PM
1class Solution {
2    public int findJudge(int n, int[][] trust) {
3        int[] out = new int[n+1];
4        int[] in = new int[n+1];
5        for (int i=0; i<trust.length; i++) {
6            int from = trust[i][0];
7            int to = trust[i][1];
8            out[from]++;
9            in[to]++;
10        }
11        for (int i=1; i<n+1; i++) {
12            if (out[i] == 0 && in[i] == n-1) {
13                return i;
14            }
15        }
16        return -1;
17    }
18}