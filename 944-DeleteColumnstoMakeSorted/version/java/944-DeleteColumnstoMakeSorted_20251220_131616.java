// Last updated: 12/20/2025, 1:16:16 PM
1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int ans = 0;
4        for (int j = 0; j < strs[0].length(); j++) {
5            int prev = strs[0].charAt(j) - 'a';
6            for (int i = 1; i < strs.length; i++) {
7                int cur = strs[i].charAt(j) - 'a';
8                if (prev>cur) {
9                    ans++;
10                    break;
11                } else {
12                    prev = cur;
13                }
14            }
15        }
16        return ans;
17    }
18}