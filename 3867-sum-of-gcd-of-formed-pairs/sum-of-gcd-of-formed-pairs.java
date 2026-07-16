class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    // public int gcd(int a, int b) {
    //     if (b == 0) return a;
    //     return gcd(b, a%b);
    // }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int max = nums[0];
        for (int i=0; i<n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }
        Arrays.sort(prefixGcd);
        long sum = 0;
        for (int i=0, j=n-1; i<j; i++, j--) {
            sum += gcd(prefixGcd[i], prefixGcd[j]);
        }
        return sum;
    }
}