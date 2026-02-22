// Last updated: 2/22/2026, 8:18:06 AM
1class Solution {
2    public int scoreDifference(int[] nums) {
3        int chance = 1;
4        int score1 = 0;
5        int score2 = 0;
6        for (int i = 0; i < nums.length; i++) {
7            if (nums[i] % 2 != 0) {
8                chance = 3 - chance;
9            }
10            if ((i + 1) % 6 == 0) {
11                chance = 3 - chance;
12            }
13            if (chance == 1) {
14                score1 += nums[i];
15            } else if (chance == 2) {
16                score2 += nums[i];
17            }
18        }
19        return score1 - score2;
20    }
21}