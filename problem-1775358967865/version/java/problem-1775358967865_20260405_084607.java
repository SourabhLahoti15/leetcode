// Last updated: 4/5/2026, 8:46:07 AM
1class Solution {
2    public int mirrorFrequency(String s) {
3        Map<Character, Integer> freq = new HashMap<>();
4        for (char c : s.toCharArray()) {
5            freq.put(c, freq.getOrDefault(c, 0) + 1);
6        }
7        
8        Set<Character> visited = new HashSet<>();
9        int total = 0;
10        
11        for (char c : freq.keySet()) {
12            if (visited.contains(c)) continue;
13            
14            char m;
15            if (Character.isLetter(c)) {
16                m = (char) ('z' - (c - 'a'));
17            } else {
18                m = (char) ('9' - (c - '0'));
19            }
20            
21            visited.add(c);
22            visited.add(m);
23            
24            int freqC = freq.getOrDefault(c, 0);
25            int freqM = freq.getOrDefault(m, 0);
26            total += Math.abs(freqC - freqM);
27        }
28        
29        return total;
30    }
31}