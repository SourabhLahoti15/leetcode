// Last updated: 6/14/2026, 10:04:24 AM
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[1];
        int n = nums.length;
        for (int i=0; i<n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        boolean[] a = new boolean[max - min + 1];
        for (int i=0; i<n; i++) {
            a[nums[i] - min] = true;
        }
        List<Integer> l = new ArrayList<>();
        for (int i=0; i<a.length; i++) {
            if (!a[i]) {
                l.add(i+min);
            }
        }
        return l;
    }
}