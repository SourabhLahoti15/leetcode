class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int local = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') local++;
            else if (ch == ')') local--;
            ans = Math.max(ans, local);
        }
        return ans;
    }
}