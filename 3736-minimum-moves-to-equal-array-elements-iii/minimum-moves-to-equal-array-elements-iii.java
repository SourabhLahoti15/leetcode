class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i=0; i<n; i++) {
            if (nums[i] > max) max = nums[i];
        }
        int moves = 0;
        for (int i=0; i<nums.length; i++) {
            moves += max - nums[i];
        }
        return moves;
    }
}