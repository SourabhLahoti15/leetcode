// Last updated: 3/30/2026, 10:19:50 AM
1class Solution {
2    public boolean checkStrings(String s1, String s2) {
3        int n = s1.length();
4        HashMap<Character, Integer> odd1 = new HashMap<>();
5        HashMap<Character, Integer> even1 = new HashMap<>();
6        HashMap<Character, Integer> odd2 = new HashMap<>();
7        HashMap<Character, Integer> even2 = new HashMap<>();
8        for (int i=0; i<n; i++) {
9            char ch1 = s1.charAt(i);
10            char ch2 = s2.charAt(i);
11            if (i % 2 == 0) {
12                even1.put(ch1, even1.getOrDefault(ch1, 0)+1);
13                even2.put(ch2, even2.getOrDefault(ch2, 0)+1);
14            } else {
15                odd1.put(ch1, odd1.getOrDefault(ch1, 0)+1);
16                odd2.put(ch2, odd2.getOrDefault(ch2, 0)+1);
17            }
18        }
19        return even1.equals(even2) && odd1.equals(odd2);
20    }
21}