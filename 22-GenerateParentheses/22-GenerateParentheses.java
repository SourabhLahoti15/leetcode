// Last updated: 12/17/2025, 10:54:30 AM
class Solution {
    public void recursion(String cur, int open, int close, int n, List<String> ans) {
        if (cur.length() == 2*n) {
            ans.add(cur);
            return;
        }
        if (open < n) {
            recursion(cur + "(", open + 1, close, n, ans);
        }
        if (close < open) {
            recursion(cur + ")", open, close + 1, n, ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recursion("", 0, 0, n, ans);
        return ans;
    }
}