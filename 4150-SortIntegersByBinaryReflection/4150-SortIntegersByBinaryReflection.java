// Last updated: 12/17/2025, 10:50:39 AM
import java.util.Arrays;
class Solution {
    public int binRef(int n) {
        String bin = Integer.toBinaryString(n);
        String rev = new StringBuilder(bin).reverse().toString();
        return Integer.parseInt(rev, 2);
    }
    public int[] sortByReflection(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            int ra = binRef(a);
            int rb = binRef(b);
            if (ra == rb) {
                return Integer.compare(a, b);                
            }
            return Integer.compare(ra, rb);
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}