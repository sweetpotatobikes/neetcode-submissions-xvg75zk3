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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        // process left and right recursively
        int left = Math.max(0,helper(node.left));
        int right = Math.max(0,helper(node.right));

        // current path sum
        result = Math.max(result, node.val + left + right);

        return node.val + Math.max(left, right);
    }
}
