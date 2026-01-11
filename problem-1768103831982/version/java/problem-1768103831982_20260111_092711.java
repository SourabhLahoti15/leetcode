// Last updated: 1/11/2026, 9:27:11 AM
1class Solution {
2    // public boolean isSimilar(String s, String t) {
3    //     int distance = s.charAt(0) - t.charAt(0);
4    //     if (distance < 0) {
5    //         distance += 26;
6    //     }
7    //     for (int i=0; i<s.length(); i++) {
8    //         int dis = s.charAt(i) - t.charAt(i);
9    //         if (dis < 0) {
10    //             dis += 26;
11    //         } 
12    //         if (dis != distance) {
13    //             return false;
14    //         }
15    //     }
16    //     return true;
17    // }
18    public String normalize(String word) {
19        StringBuilder sb = new StringBuilder();
20        int base = word.charAt(0);
21        for (char c:word.toCharArray()) {
22            int diff = base - c;
23            if (diff < 0) diff += 26;
24            sb.append(diff).append('#');
25        }
26        return sb.toString();
27    }
28    public long countPairs(String[] words) {
29        long ans = 0;
30        Map<String, Integer> map = new HashMap<>();
31        for (String word : words) {
32            String key = normalize(word);
33            int freq = map.getOrDefault(key, 0);
34            ans += freq;
35            map.put(key, freq+1);
36        }
37        return ans;
38    }
39}