// Last updated: 12/17/2025, 10:52:13 AM
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<String> stk = new Stack<>();
        int prevtime = -1;
        for (String log : logs) {
            String[] logarr = log.split(":");
            if (logarr[1].equals("start")) {
                if (!stk.isEmpty()) {
                    String startlog = stk.peek();
                    String[] startlogarr = startlog.split(":");
                    ans[Integer.parseInt(startlogarr[0])] += Integer.parseInt(logarr[2]) - prevtime;
                }
                stk.push(log);
                prevtime = Integer.parseInt(logarr[2]);
            } else {
                stk.pop();
                ans[Integer.parseInt(logarr[0])] += Integer.parseInt(logarr[2]) - prevtime + 1;
                prevtime = Integer.parseInt(logarr[2]) + 1;
            }
        }
        return ans;
    }
}