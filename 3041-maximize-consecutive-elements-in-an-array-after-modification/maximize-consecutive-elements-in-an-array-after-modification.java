class Solution {
    int[] nums;
    int[][] dp;
    public int find(int start, int target) {
        int end = nums.length;
        while (start < end) {
            int mid = start + (end-start)/2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            } 
        }
        if (start < nums.length && nums[start] == target) {
            return start;
        }
        return -1;
    }
    public int solve(int i, int inc) {
        if (dp[i][inc] != -1) return dp[i][inc];
        int curval = nums[i] + inc;
        int len = 1;

        int j = find(i+1, curval+1);
        if (j != -1) {
            len = Math.max(len, 1 + solve(j, 0));
        }

        j = find(i+1, curval);
        if (j != -1) {
            len = Math.max(len, 1 + solve(j, 1));
        }
        return dp[i][inc] = len;
    }
    public int maxSelectedElements(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        Arrays.sort(nums);
        dp = new int[n+1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = 1;
        for (int i=0; i<n; i++) {
            result = Math.max(result, Math.max(solve(i, 0), solve(i, 1)));
        }
        return result;
    }
}