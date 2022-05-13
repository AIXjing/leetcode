/**
 * Fundamental element of Binary tree
 * defined by Leetcode, applying to all the classes in this package
 */
package TreePrac;
class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode() {}
    TreeNode(T val) { this.val = val; }
    TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
