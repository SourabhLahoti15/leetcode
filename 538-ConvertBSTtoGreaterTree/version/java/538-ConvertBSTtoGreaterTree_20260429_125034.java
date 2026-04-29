// Last updated: 4/29/2026, 12:50:34 PM
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
    static int sum;
    public TreeNode convertBST(TreeNode root) {
        sum=0;
        revInorder(root);
        return root;
    }
    private void revInorder(TreeNode root){
        if(root==null) return;
        revInorder(root.right);
        int val=root.val;
        root.val+=sum;
        sum+=val;
        revInorder(root.left);
    }
}