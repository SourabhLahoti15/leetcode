// Last updated: 3/17/2026, 8:22:01 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public boolean dfs(TreeNode node, long min, long max) {
18        if (node == null)
19            return true;
20
21        if (node.val <= min || node.val >= max)
22            return false;
23
24        return dfs(node.left, min, node.val) &&
25                dfs(node.right, node.val, max);
26    }
27
28    public boolean isValidBST(TreeNode root) {
29        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
30    }
31}