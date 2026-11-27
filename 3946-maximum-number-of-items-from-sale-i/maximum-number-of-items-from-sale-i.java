class Solution {
    int n;
    int[][] dp;
    int[] copies;
    int[][] items;
    int minPrice;
    public int solve(int i, int budget) {
        if (i >= n) return budget/minPrice;
        if (dp[i][budget] != -1) {
            return dp[i][budget];
        }
        int take = 0;
        int price = items[i][1];
        if (price <= budget) {
            take = 1 + copies[i] + solve(i+1, budget - price);
        }
        int skip = solve(i+1, budget);
        return dp[i][budget] = Math.max(take, skip);
    }
    public int maximumSaleItems(int[][] items, int budget) {
        this.items = items;
        n = items.length;
        dp = new int[n+1][budget+1];
        copies = new int[n];
        minPrice = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
            int copy = 0;
            for (int j=0; j<n; j++) {
                if (i == j) continue;
                if (items[j][0] % items[i][0] == 0) {
                    copy++;
                }
            }
            copies[i] = copy;
        }
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, budget);
    }
}