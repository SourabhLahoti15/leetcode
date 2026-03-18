// Last updated: 3/18/2026, 4:49:13 PM
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
17    public boolean isLeaf(TreeNode root) {
18        return root.left == null && root.right == null;
19    }
20    public int sumOfLeftLeaves(TreeNode root) {
21        if (root == null) {
22            return 0;
23        }
24        int sum = 0;
25        if (root.left != null && isLeaf(root.left)) {
26            sum = root.left.val;
27        }
28        sum += sumOfLeftLeaves(root.left);
29        sum += sumOfLeftLeaves(root.right);
30        return sum;
31    }
32}