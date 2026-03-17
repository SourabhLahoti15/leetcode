// Last updated: 3/17/2026, 12:15:06 PM
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
17    int sum = Integer.MIN_VALUE;
18    public int pathSum(TreeNode root) {
19        if (root == null) return 0;
20        int left = pathSum(root.left);
21        int right = pathSum(root.right);
22        int op1 = Math.max(left, right) + root.val;
23        int op2 = left + right + root.val;
24        int op3 = root.val;
25        sum = Math.max(sum, Math.max(op1, Math.max(op2, op3)));
26        return Math.max(op1, op3);
27    }
28    public int maxPathSum(TreeNode root) {
29        pathSum(root);
30        return sum;
31    }
32}