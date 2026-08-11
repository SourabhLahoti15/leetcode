class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        int n = nums.length;
        for (int i=1; i<n; i++) {
            if (nums[i] == nums[i-1]+1) {
                sum += nums[i];
            } else {
                break;
            }
        }
        while (true) {
            boolean found = false;
            for (int i=0; i<n; i++) {
                if (nums[i] == sum) found = true;
            }
            if (found) {
                sum++;
            } else {
                return sum;
            }
        }
    }
}