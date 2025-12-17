// Last updated: 12/17/2025, 10:52:51 AM
class Solution {
    public void recursion(int l, int r, char[] s) {
        if (l >= r) {
            return;
        }
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        recursion(l+1, r-1, s);
    }
    public void reverseString(char[] s) {
        int l = 0, r = s.length-1;
        recursion(l, r, s);
        return;
    }
}