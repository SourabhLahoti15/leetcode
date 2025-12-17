// Last updated: 12/17/2025, 10:51:34 AM
class Solution {
    public boolean isTopinTarget(Stack<Integer> stack, int[] array) {
        int top = stack.peek();
        for (int i : array) {
            if (i == top) return true;
        }
        return false;
    }
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if (target.length == 0) return ans;
        int max = Integer.MIN_VALUE;
        for (int i : target) {
            if (i>max) {
                max=i;
            }
        }
        int m = Math.min(max, n);
        for (int i=1; i<=m; i++) {
            stack.push(i);
            ans.add("Push");
            if (!isTopinTarget(stack, target)) {
                stack.pop();
                ans.add("Pop");
            }
        }
        return ans;
    }
}