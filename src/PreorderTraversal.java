import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @source: https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
class PreorderTraversal {
    public static List<Character> preorderTraversal(TreeNode<Character> root) {
        List<Character> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode<Character> a = new TreeNode('a');
        TreeNode<Character> b = new TreeNode('b');
        TreeNode<Character> c = new TreeNode('c');
        TreeNode<Character> d = new TreeNode('d');
        TreeNode<Character> f = new TreeNode('f');
        TreeNode<Character> e = new TreeNode('e');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        System.out.println("Preorder Traversal using Recursion: "
                + Arrays.toString(preorderTraversal(a).toArray()));
    }

    // Definition for a binary tree node.
    static class TreeNode<T> {
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
}
