// Last updated: 6/14/2026, 10:04:05 AM
class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int bulb : bulbs) {
            if (ans.contains(bulb)) {
                int idx = ans.indexOf(bulb);
                ans.remove(idx);
            } else {
                ans.add(bulb);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}