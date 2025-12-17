// Last updated: 12/17/2025, 10:53:04 AM
class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            if (hs.contains(num)) {
                hs.remove(num);
            } else {
                hs.add(num);
            }
        }
        int[] ans = new int[2];
        int idx = 0;
        for (int num : hs) {
            ans[idx++] = num;
        }
        return ans;
    }
}