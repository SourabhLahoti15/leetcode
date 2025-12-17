// Last updated: 12/17/2025, 10:54:24 AM
class Solution {
    public int findIdx(int[] nums, int target, boolean first){
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                idx = mid;
                if(first){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = findIdx(nums, target, true);
        int last = findIdx(nums, target, false);
        return new int[]{first, last};
    }
}