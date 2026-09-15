class Solution {
    public boolean isPalindrome(int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
    String s;
    int k;
    int n;
    int[][] dp;
    public int solve(int i, int j) {
        if (j >= n) return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (isPalindrome(i, j)) {
            int take = 1 + solve(j+1, j+k);
            return dp[i][j] = take;
        }
        int slide = solve(i+1, j+1);
        int grow = solve(i, j+1);
        return dp[i][j] = Math.max(slide, grow);
    }
    public int maxPalindromes(String s, int k) {
        this.s = s;
        this.k = k;
        n = s.length();
        dp = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, k-1);
    }
}