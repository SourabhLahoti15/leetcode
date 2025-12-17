// Last updated: 12/17/2025, 10:51:46 AM
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int value = 0;
        List<Boolean> l = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            value = ((value << 1) | nums[i]) % 5;
            if (value%5 == 0) {
                l.add(true);
            } else {
                l.add(false);
            }
        }
        return l;
    }
}