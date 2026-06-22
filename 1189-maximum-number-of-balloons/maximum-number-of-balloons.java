class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            if ("balloon".contains(String.valueOf(ch))) {
                hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (char ch : "balloon".toCharArray()) {
            int freq = hmap.getOrDefault(ch, 0);
            if (ch == 'l' || ch == 'o') freq /= 2;
            ans = Math.min(ans, freq);
        }
        return ans;
    }
}