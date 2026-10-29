class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i=1; i<n; i++) {
            if (nums[i] == nums[i-1]) {
                nums[i-1] *= 2;
                nums[i] = 0;
            }
        }
        int[] result = new int[n];
        int nzp = 0;
        for (int i=0; i<n; i++) {
            if (nums[i] != 0) {
                result[nzp] = nums[i];
                nzp++;
            }
        }
        return result;
    }
}