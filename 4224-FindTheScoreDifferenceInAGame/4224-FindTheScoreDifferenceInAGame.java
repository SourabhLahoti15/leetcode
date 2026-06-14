// Last updated: 6/14/2026, 10:03:59 AM
class Solution {
    public int scoreDifference(int[] nums) {
        int chance = 1;
        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                chance = 3 - chance;
            }
            if ((i + 1) % 6 == 0) {
                chance = 3 - chance;
            }
            if (chance == 1) {
                score1 += nums[i];
            } else if (chance == 2) {
                score2 += nums[i];
            }
        }
        return score1 - score2;
    }
}