// Last updated: 6/14/2026, 10:04:08 AM
class Solution {
    public boolean isMonobit(String bin) {
        char c = bin.charAt(0);
        for (char ch : bin.toCharArray()) {
            if (ch != c) {
                return false;
            }
        }
        return true;
    }
    public int countMonobit(int n) {
        int count = 0;
        for (int i=0; i<=n; i++) {
            if (isMonobit(Integer.toBinaryString(i)))
                count++;
        }
        return count;
    }
}