// Last updated: 12/17/2025, 10:53:57 AM
import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int maxar = 0;
        int[] leftsmall = new int[heights.length];
        Arrays.fill(leftsmall, -1);
        for (int i=heights.length-1; i>=0; i--) {
            while (!stk.isEmpty() && heights[i] < heights[stk.peek()]) {
                int idx = stk.pop();
                leftsmall[idx] = i;
            }
            stk.push(i);
        }
        stk.clear();
        int[] rightsmall = new int[heights.length];
        Arrays.fill(rightsmall, heights.length);
        for (int i=0; i<heights.length; i++) {
            while (!stk.isEmpty() && heights[i] < heights[stk.peek()]) {
                int idx = stk.pop();
                rightsmall[idx] = i;
            }
            stk.push(i);
        }
        for (int i=0; i<heights.length; i++) {
            int ar = heights[i] * (rightsmall[i] - leftsmall[i] - 1);
            if (ar > maxar) {
                maxar = ar;
            }
        }
        return maxar;
    }
}