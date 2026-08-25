class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hset = new HashSet<>();
        for (int num : nums) {
            hset.add(num);
        }
        int i = 1;
        while (true) {
            if (!hset.contains(k * i))
                return k * i;
            i++;
        }
    }
}