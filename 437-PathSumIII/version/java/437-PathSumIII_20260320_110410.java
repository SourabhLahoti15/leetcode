// Last updated: 3/20/2026, 11:04:10 AM
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
17    public int sum(TreeNode root, long targetSum) {
18        if (root == null) return 0;
19        int count = 0;
20        if (root.val == targetSum) count++;
21        count += sum(root.left, targetSum-root.val);
22        count += sum(root.right, targetSum-root.val);
23        return count;
24    }
25    public int pathSum(TreeNode root, int targetSum) {
26        if (root == null) return 0;
27        int rootsum = sum(root, targetSum);
28        int left = pathSum(root.left, targetSum);
29        int right = pathSum(root.right, targetSum);
30        return rootsum + left + right;
31    }
32}