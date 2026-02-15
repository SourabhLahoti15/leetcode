// Last updated: 2/15/2026, 8:07:08 AM
1class Solution {
2    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
3        List<Integer> ans = new ArrayList<Integer>();
4        for (int bulb : bulbs) {
5            if (ans.contains(bulb)) {
6                int idx = ans.indexOf(bulb);
7                ans.remove(idx);
8            } else {
9                ans.add(bulb);
10            }
11        }
12        Collections.sort(ans);
13        return ans;
14    }
15}