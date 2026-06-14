// Last updated: 6/14/2026, 10:03:43 AM
class Solution {
    public int mirrorFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        Set<Character> visited = new HashSet<>();
        int total = 0;
        
        for (char c : freq.keySet()) {
            if (visited.contains(c)) continue;
            
            char m;
            if (Character.isLetter(c)) {
                m = (char) ('z' - (c - 'a'));
            } else {
                m = (char) ('9' - (c - '0'));
            }
            
            visited.add(c);
            visited.add(m);
            
            int freqC = freq.getOrDefault(c, 0);
            int freqM = freq.getOrDefault(m, 0);
            total += Math.abs(freqC - freqM);
        }
        
        return total;
    }
}