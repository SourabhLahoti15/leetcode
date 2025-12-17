// Last updated: 12/17/2025, 10:52:11 AM
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int duplicate = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                duplicate = e.getKey();
                break;
            }
        }
        ans[0] = duplicate;
        int acsum = 0;
        for (int i : nums) {
            acsum += i;
        }
        int exsum = n*(n+1)/2;
        int missingnum = exsum - acsum + duplicate;
        ans[1] = missingnum;
        return ans;
    }
}