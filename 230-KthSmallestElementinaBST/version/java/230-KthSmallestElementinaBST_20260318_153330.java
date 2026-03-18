// Last updated: 3/18/2026, 3:33:30 PM
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
17    List<Integer> l;
18    public void inorder(TreeNode root) {
19        if (root == null) return;
20        inorder(root.left);
21        l.add(root.val);
22        inorder(root.right);
23    }
24    public int kthSmallest(TreeNode root, int k) {
25        l = new ArrayList<>();
26        inorder(root);
27        return l.get(k-1);
28    }
29}