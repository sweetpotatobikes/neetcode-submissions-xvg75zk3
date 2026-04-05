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

public class Codec {
    private static final String SEPARATOR = " ";
    private static final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) result.append(NULL);
            else {
                result.append(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
            result.append(SEPARATOR);
        }
        return result.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] nodes = data.split(SEPARATOR);
        int size = nodes.length;

        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(nodes[0]);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (i < size && !nodes[i].equals(NULL)) {
                TreeNode left = new TreeNode();
                left.val = Integer.parseInt(nodes[i]);
                node.left = left;
                q.offer(left);
            }
            i++;
            if (i < size && !nodes[i].equals(NULL)) {
                TreeNode right = new TreeNode();
                right.val = Integer.parseInt(nodes[i]);
                node.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}
