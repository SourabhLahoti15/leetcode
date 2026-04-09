// Last updated: 4/9/2026, 10:43:39 AM
1class Solution {
2    public int solve(int i, int j, int idx) {
3        if (i < 0 || i >= n || j < 0 || j >= n) {
4            return -1;
5        }
6        if (idx >= m) {
7            return 0;
8        }
9        // if (dp[i][j][idx] != -1) {
10        //     return dp[i][j][idx];
11        // }
12        int ans = 0;
13        switch (s.charAt(idx)) {
14            case 'L':
15                ans = 1 + solve(i, j-1, idx+1);
16                break;
17            case 'R':
18                ans = 1 + solve(i, j+1, idx+1);
19                break;
20            case 'U':
21                ans = 1 + solve(i-1, j, idx+1);
22                break;
23            case 'D':
24                ans = 1 + solve(i+1, j, idx+1);
25                break;
26        }
27        // return dp[i][j][idx] = ans;
28        return ans;
29    }
30    int n;
31    int m;
32    String s;
33    // int[][][] dp;
34    public int[] executeInstructions(int n, int[] startPos, String s) {
35        this.n = n;
36        this.s = s;
37        m = s.length();
38        int[] answer = new int[m];
39        // dp = new int[n][n][m];
40        // for (int i=0; i<n; i++) {
41        //     for (int j=0; j<n; j++) {
42        //         Arrays.fill(dp[i][j], -1);
43        //     }
44        // }
45        for (int idx=0; idx<m; idx++) {
46            answer[idx] = solve(startPos[0], startPos[1], idx);
47        }
48        return answer;
49    }
50}