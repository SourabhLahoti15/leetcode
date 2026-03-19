// Last updated: 3/19/2026, 9:20:53 AM
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
20    public int findBottomLeftValue(TreeNode root) {
21        Queue<TreeNode> q = new LinkedList<>();
22        int val = -1;
23        if (root == null) return val;
24        q.offer(root);
25        while (!q.isEmpty()) {
26            TreeNode node = q.poll();
27            if (isLeaf(node)) {
28                val = node.val;
29            }
30            if (node.right != null) q.offer(node.right);
31            if (node.left != null) q.offer(node.left);
32        }
33        return val;
34    }
35}