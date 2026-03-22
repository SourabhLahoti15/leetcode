// Last updated: 3/22/2026, 8:46:06 AM
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int minodd = Integer.MAX_VALUE;
4        boolean hasOdd = false;
5        for (int num : nums1) {
6            if (num % 2 != 0) {
7                hasOdd = true;
8                minodd = Math.min(minodd, num);
9            }
10        }
11        if (!hasOdd) return true;
12        for (int num : nums1) {
13            if (num < minodd) return false;
14        }
15        return true;
16    }
17}