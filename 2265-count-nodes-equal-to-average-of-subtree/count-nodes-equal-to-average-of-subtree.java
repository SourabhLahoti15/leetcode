/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count;
    public int findSum(TreeNode root, int[] n) {
        if (root == null) return 0;
        n[0]++;
        return root.val + findSum(root.left, n) + findSum(root.right, n);
    }
    public void solve(TreeNode root) {
        if (root == null) return;
        int[] n = {0};
        int sum = findSum(root, n);
        if (sum/n[0] == root.val) {
            count++;
        }
        solve(root.left);
        solve(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        solve(root);
        return count;
    }
}