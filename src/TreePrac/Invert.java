/**
 * @source: https://leetcode.com/problems/invert-binary-tree/
 */
package TreePrac;

import java.util.Stack;

public class Invert {
    public TreeNode invertTreeRec(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode prevLeft = root.left;
        root.left = invertTreeRec(root.right);
        root.right = invertTreeRec(prevLeft);
        return root;
    }


    /*
    The above solution is correct, but it is also bound to the application stack,
    which means that it's no so much scalable
    - (you can find the problem size that will overflow the stack and crash your application),
    so more robust solution would be to use stack data structure.
     */
    public TreeNode invertTreeIte(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode p = stack.pop();
            // swap left and right node for each parent node
            TreeNode left = p.left;
            p.left = p.right;
            p.right = left;
            if (p.left != null) stack.push(p.left);
            if (p.right != null) stack.push(p.right);
        }
        return root;
    }
}
