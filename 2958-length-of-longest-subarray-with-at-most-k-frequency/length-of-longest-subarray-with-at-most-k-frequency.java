class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int s = 0;
        int e = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        while (e < n) {
            hmap.put(nums[e], hmap.getOrDefault(nums[e], 0) + 1);
            while (hmap.get(nums[e]) > k) {
                hmap.put(nums[s], hmap.get(nums[s]) - 1);
                s++;
            }
            maxLen = Math.max(maxLen, e-s+1);
            e++;
        }
        return maxLen;
    }
}