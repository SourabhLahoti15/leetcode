// Last updated: 3/21/2026, 6:42:21 PM
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        // HashSet<Character> set = new HashSet<>();
4        HashMap<Character, Integer> map = new HashMap<>();
5        int n = s.length();
6        int l = 0;
7        int r = 0;
8        int maxlen = 0;
9        while (r < n) {
10            char ch = s.charAt(r);
11            if (map.containsKey(ch)) {
12                int idx = map.get(ch);
13                l = Math.max(l, idx + 1);
14            }
15            map.put(ch, r);
16            maxlen = Math.max(maxlen, r-l+1);
17            r++;
18        }
19        return maxlen;
20    }
21}