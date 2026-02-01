// Last updated: 2/1/2026, 8:07:42 AM
1class Solution {
2    public boolean isMonobit(String bin) {
3        char c = bin.charAt(0);
4        for (char ch : bin.toCharArray()) {
5            if (ch != c) {
6                return false;
7            }
8        }
9        return true;
10    }
11    public int countMonobit(int n) {
12        int count = 0;
13        for (int i=0; i<=n; i++) {
14            if (isMonobit(Integer.toBinaryString(i)))
15                count++;
16        }
17        return count;
18    }
19}