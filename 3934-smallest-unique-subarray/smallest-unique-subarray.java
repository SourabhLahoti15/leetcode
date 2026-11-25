class Solution {
    final long MOD = 1_000_000_007L;
    long base;
    int[] nums;
    private long power(long a, long exp) {
        if (exp == 0) return 1;
        long half = power(a, exp/2);
        long result = (half * half) % MOD;
        if (exp % 2 == 1) {
            result = (result * a) % MOD;
        }
        return result;
    }
    public boolean check(int size) {
        int n = nums.length;
        long hash = 0;
        Map<Long, Integer> map = new HashMap<>();
        // long p = (long) Math.pow(base, size-1);
        long p = power(base % MOD, size - 1);
        int i = 0;
        int j = 0;
        while (j < n) {
            hash = (hash * base + nums[j]) % MOD;
            if (j - i + 1 < size) {
                j++;
            } else {
                map.put(hash, map.getOrDefault(hash, 0) + 1);
                hash = (hash - (nums[i] * p) % MOD + MOD) % MOD;
                i++;
                j++;
            }
        }
        for (int count : map.values()) {
            if (count == 1) return true;
        }
        return false;

    }
    public int smallestUniqueSubarray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        this.base = Arrays.stream(nums).max().getAsInt() + 1L;
        int result = n;
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (check(mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}