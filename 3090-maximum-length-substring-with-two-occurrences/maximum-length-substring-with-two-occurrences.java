class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> hmap = new HashMap<>();
        int st = 0;
        int end = 0;
        int maxLen = 0;
        while (end < n) {
            hmap.put(s.charAt(end), hmap.getOrDefault(s.charAt(end), 0) + 1);
            while (hmap.get(s.charAt(end)) > 2) {
                hmap.put(s.charAt(st), hmap.get(s.charAt(st)) - 1);
                st++;
            }
            maxLen = Math.max(maxLen, end - st + 1);
            end++;
        }
        return maxLen;
    }
}