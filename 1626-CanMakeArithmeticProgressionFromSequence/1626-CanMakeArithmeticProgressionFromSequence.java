// Last updated: 12/17/2025, 10:51:27 AM
import java.util.*;
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int diff = arr[1] - arr[0];
        for (int i=1; i<n; i++) {
            int localdiff = arr[i] - arr[i-1];
            if (localdiff != diff) {
                return false;
            }
        }
        return true;
    }
}