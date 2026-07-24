class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hset = new HashSet<>();
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int xor = nums[i] ^ nums[j];
                hset.add(xor);
            }
        }
        HashSet<Integer> ans = new HashSet<>();
        for (int x : hset) {
            for (int y : nums) {
                ans.add(x^y);
            }
        }
        return ans.size();
    }
}