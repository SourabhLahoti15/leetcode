// Last updated: 6/14/2026, 10:03:36 AM
class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            boolean isEven = nums[i] % 2 == 0;
            for (int j=i+1; j<n; j++) {
                if ((isEven && nums[j] % 2 != 0) || !isEven && nums[j] % 2 == 0)
                    answer[i] += 1;
            }
        }
        return answer;
    }
}