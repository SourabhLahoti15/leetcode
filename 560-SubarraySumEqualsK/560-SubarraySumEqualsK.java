// Last updated: 12/17/2025, 10:52:22 AM
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        for (int j=0; j<nums.length; j++) {
            int val = prefix[j]-k;
            ans += hm.getOrDefault(val, 0);
            hm.put(prefix[j], hm.getOrDefault(prefix[j], 0)+1);
        }
        return ans;
    }
}