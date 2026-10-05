class Solution {
    public boolean func(int i, int val) {
        if (i == s.length()) {
            return val == 0;
        }
        if (val < 0) return false;
        if (dp[i][val] != -1) return dp[i][val] == 1;
        if (s.charAt(i) == '(') {
            boolean ans = func(i+1, val+1);
            if (ans) dp[i][val] = 1;
            else dp[i][val] = 0;
            return ans;
        } else if (s.charAt(i) == ')') {
            boolean ans = func(i+1, val-1);
            if (ans) dp[i][val] = 1;
            else dp[i][val] = 0;
            return ans;
        } else {
            boolean ans = func(i+1, val) || func(i+1, val+1) || func(i+1, val-1);
            if (ans) dp[i][val] = 1;
            else dp[i][val] = 0;
            return ans;
        }
    }
    String s; 
    int[][] dp;   
    public boolean checkValidString(String s) {
        this.s = s;
        int n = s.length();
        dp = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return func(0, 0);
    }
}