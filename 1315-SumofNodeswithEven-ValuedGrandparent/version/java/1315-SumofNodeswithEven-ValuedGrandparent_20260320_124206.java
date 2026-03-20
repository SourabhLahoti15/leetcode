// Last updated: 3/20/2026, 12:42:06 PM
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
17    public int sumEvenGrandparent(TreeNode root) {
18        if (root == null) return 0;
19        int sum = 0;
20        if (root.val % 2 == 0) {
21            if (root.left != null && root.left.left != null) sum += root.left.left.val;
22            if (root.left != null && root.left.right != null) sum += root.left.right.val;
23
24            if (root.right != null && root.right.left != null) sum += root.right.left.val;
25            if (root.right != null && root.right.right != null) sum += root.right.right.val;
26        }
27        return sum + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
28    }
29}