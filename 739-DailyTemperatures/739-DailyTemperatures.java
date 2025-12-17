// Last updated: 12/17/2025, 10:52:06 AM
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stk = new Stack<>();
        for (int i=0; i<temperatures.length; i++) {
            while (!stk.isEmpty() && temperatures[i]>temperatures[stk.peek()]) {
                int idx = stk.pop();
                answer[idx] = i - idx;
            }
            stk.push(i);
        }
        return answer;
    }
}