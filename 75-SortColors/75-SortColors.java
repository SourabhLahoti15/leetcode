// Last updated: 12/17/2025, 10:54:02 AM
class Solution {
    public void sortColors(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int j = i+1;
            while (j<nums.length){
                if (nums[j]<nums[i]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                j++;
            }
        }
    }
}