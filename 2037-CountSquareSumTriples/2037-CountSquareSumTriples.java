// Last updated: 12/17/2025, 10:51:15 AM
class Solution {
    public int countTriples(int n) {
        int count = 0;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                for (int k=1; k<=n; k++) {
                    if (i != j && j != k && i != k) {
                        if (Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(k, 2)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}