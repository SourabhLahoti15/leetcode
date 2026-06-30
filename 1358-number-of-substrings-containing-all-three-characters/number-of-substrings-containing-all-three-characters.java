class Solution {
    public boolean isValid(int[] count) {
        if (count[0]>0 && count[1]>0 && count[2]>0) return true;
        return false;
    }
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int left = 0;
        int right = 0;
        int[] count = new int[3];
        while (right < n) {
            char rightch = s.charAt(right);
            count[rightch - 'a']++;
            while (isValid(count)) {
                ans += n-right;
                char leftch = s.charAt(left);
                count[leftch - 'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }
}