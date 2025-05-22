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
class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode inverted = new TreeNode(root.val);
        rec(root, inverted);
        return inverted;
    }

    private void rec(TreeNode root, TreeNode sample) {
        if (root.left != null) {
            sample.right = new TreeNode(root.left.val);
            rec(root.left, sample.right);
        }
        if (root.right != null) {
            sample.left = new TreeNode(root.right.val);
            rec(root.right, sample.left);
        }
    }
}
