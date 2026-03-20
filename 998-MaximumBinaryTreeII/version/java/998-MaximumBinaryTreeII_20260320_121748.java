// Last updated: 3/20/2026, 12:17:48 PM
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
17    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
18        if (root == null) {
19            return new TreeNode(val);
20        }
21        if (root.val < val) {
22            TreeNode node = new TreeNode(val);
23            node.left = root;
24            return node;
25        }
26        root.right = insertIntoMaxTree(root.right, val);
27        return root;
28    }
29}