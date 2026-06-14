// Last updated: 6/14/2026, 10:04:12 AM
class Solution {
    // public boolean isSimilar(String s, String t) {
    //     int distance = s.charAt(0) - t.charAt(0);
    //     if (distance < 0) {
    //         distance += 26;
    //     }
    //     for (int i=0; i<s.length(); i++) {
    //         int dis = s.charAt(i) - t.charAt(i);
    //         if (dis < 0) {
    //             dis += 26;
    //         } 
    //         if (dis != distance) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public String normalize(String word) {
        StringBuilder sb = new StringBuilder();
        int base = word.charAt(0);
        for (char c:word.toCharArray()) {
            int diff = base - c;
            if (diff < 0) diff += 26;
            sb.append(diff).append('#');
        }
        return sb.toString();
    }
    public long countPairs(String[] words) {
        long ans = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            String key = normalize(word);
            int freq = map.getOrDefault(key, 0);
            ans += freq;
            map.put(key, freq+1);
        }
        return ans;
    }
}