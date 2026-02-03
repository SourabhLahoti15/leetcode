// Last updated: 2/3/2026, 6:00:04 PM
1class Solution {
2    public boolean isTrionic(int[] nums) {
3        int p = -1;
4        for (int i=1; i<nums.length; i++) {
5            if (nums[i] > nums[i-1]) {
6                p = i;
7            } else {
8                break;
9            }
10        }
11        if (p == -1) return false;
12        int q = -1;
13        for (int i=p+1; i<nums.length; i++) {
14            if (nums[i] < nums[i-1]) {
15                q = i;
16            } else {
17                break;
18            }
19        }
20        if (q == -1 || q == nums.length-1) return false;
21        for (int i=q+1; i<nums.length; i++) {
22            if (nums[i] <= nums[i-1]) {
23                return false;
24            }
25        }
26        return true;
27    }
28}