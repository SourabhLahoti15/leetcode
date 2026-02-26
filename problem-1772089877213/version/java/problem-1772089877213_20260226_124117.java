// Last updated: 2/26/2026, 12:41:17 PM
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
17    public int dfs(TreeNode root, int current) {
18        if (root == null) {
19            return 0;
20        }
21        current = current * 10 + root.val;
22        if (root.left == null && root.right == null) {
23            return current;
24        }
25        return dfs(root.left, current) + dfs(root.right, current);
26    }
27    public int sumNumbers(TreeNode root) {
28        return dfs(root, 0);
29    }
30}