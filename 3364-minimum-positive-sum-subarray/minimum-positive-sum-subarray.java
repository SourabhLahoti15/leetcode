class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minsum = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += nums.get(j);
                if (j-i+1 >= l && j-i+1 <= r && sum > 0) {
                    minsum = Math.min(minsum, sum);
                }
            }
        }
        if (minsum == Integer.MAX_VALUE) return -1;
        return minsum;
    }
}