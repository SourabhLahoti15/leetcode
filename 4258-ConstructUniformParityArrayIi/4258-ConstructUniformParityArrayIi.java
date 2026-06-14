// Last updated: 6/14/2026, 10:03:51 AM
class Solution {
    public boolean uniformArray(int[] nums1) {
        int minodd = Integer.MAX_VALUE;
        boolean hasOdd = false;
        for (int num : nums1) {
            if (num % 2 != 0) {
                hasOdd = true;
                minodd = Math.min(minodd, num);
            }
        }
        if (!hasOdd) return true;
        for (int num : nums1) {
            if (num < minodd) return false;
        }
        return true;
    }
}