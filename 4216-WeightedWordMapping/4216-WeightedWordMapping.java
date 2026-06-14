// Last updated: 6/14/2026, 10:04:02 AM
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            int weight = 0;
            for (char ch : word.toCharArray()) {
                weight += weights[ch-'a'];
            }
            int alpha = Math.abs((weight % 26) - 25);
            sb.append((char)(alpha + 'a'));
        }
        return sb.toString();
    }
}