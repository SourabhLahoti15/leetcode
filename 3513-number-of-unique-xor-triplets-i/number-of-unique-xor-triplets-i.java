class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3) return n;
        int k = 0;
        while (Math.pow(2, k) <= n) {
            k++;
        }
        return (int)Math.pow(2, k);
    }
}