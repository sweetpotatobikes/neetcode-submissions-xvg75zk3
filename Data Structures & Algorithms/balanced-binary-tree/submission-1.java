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
    public boolean isBalanced(TreeNode root) {
        return dfs(root).getKey();
    }

    private Pair<Boolean, Integer> dfs(TreeNode node) {
        if (node == null) return new Pair<>(true, 0);

        Pair<Boolean, Integer> left = dfs(node.left);
        Pair<Boolean, Integer> right = dfs(node.right);

        boolean balanced = (left.getKey() == true && right.getKey() == true) && (Math.abs(left.getValue() - right.getValue()) < 2);

        int height = 1 + Math.max(left.getValue(), right.getValue());

        return new Pair<Boolean, Integer>(balanced, height);
    }
}
