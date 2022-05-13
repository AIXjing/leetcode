/**
 * @source: https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */

package TreePrac;

public class BSTInsertion {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode<>(val);
        TreeNode node = root;
        if (val > (Integer) node.val) {
            if (node.right == null) {
                node.right = new TreeNode<>(val);
            } else {
                insertIntoBST(node.right, val);
            }
        } else if (val < (Integer) node.val) {
            if (node.left == null) {
                node.left = new TreeNode<>(val);
            } else {
                insertIntoBST(node.left, val);
            }
        }
        return node;
    }
}
