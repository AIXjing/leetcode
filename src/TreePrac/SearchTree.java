/**
 * @source: https://leetcode.com/problems/search-in-a-binary-search-tree/
 */

package TreePrac;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;

public class SearchTree {
    // recursion
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode node = root;
        if ((Integer) node.val == val) return node;
        else if (val < (Integer) node.val) node = root.left;
        else node = root.right;
        return searchBST(node, val);
    }

    // Depth-First-Traversal using stack
    public static TreeNode searchBSTIte(TreeNode root, int val) {
        if (root == null) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if ((Integer) node.val == val) return node;
            else if ((Integer)node.val > val) {
                if (node.left != null) stack.push(node.left);
            } else {
                if (node.right != null) stack.push(node.right);
            }
        }
        return null;
    }

    public static void main(String[] args){
        TreeNode<Integer> a = new TreeNode<>(1);
        TreeNode<Integer> b = new TreeNode<>(2);
        TreeNode<Integer> c = new TreeNode<>(3);
        TreeNode<Integer> d = new TreeNode<>(4);
        TreeNode<Integer> e = new TreeNode<>(5);
        TreeNode<Integer> f = new TreeNode<>(6);
        a.right = b;
        a.left = d;
        d.left = e;
        b.left = c;
        b.right = f;
        //     1
        //    / \
        //   4   2
        //  /   / \
        // 5   3   6
        Assert.assertEquals(new TreeNode(3), searchBST(a, 3));
    }
}
