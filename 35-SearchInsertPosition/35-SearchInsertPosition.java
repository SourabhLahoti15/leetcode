// Last updated: 12/17/2025, 10:54:22 AM
class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int s=0, e=len-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}