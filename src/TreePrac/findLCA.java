/**
 * @source: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * LCA: Lowest Common Ancestor of a BST
 */

package TreePrac;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class findLCA {
    // Breadth-First Search using queue
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == p.val)
                return p;
            if (node.val == q.val)
                return q;
            if ((Integer) node.val < Math.min((Integer) p.val, (Integer) q.val)) {
                if (node.right != null)
                    queue.add(node.right);
            }
            if (
                    (Integer) node.val > Math.min((Integer) p.val, (Integer) q.val)
                && ((Integer) node.val < Math.max((Integer) q.val, (Integer) p.val))
            )
                return node;
            if ((Integer) node.val > Math.max((Integer) q.val, (Integer) p.val)) {
                if (node.left != null)
                    queue.add(node.left);
            }
        }
        return root;
    }

    // using recursion?
    public static TreeNode findLCARec(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val) return p;
        if (root.val == q.val) return q;
        if ((Integer) root.val < Math.min((Integer) p.val, (Integer) q.val)) return findLCARec(root.right, p, q);
        if ((Integer) root.val > Math.min((Integer) p.val, (Integer) q.val)
                && ((Integer) root.val < Math.max((Integer) q.val, (Integer) p.val)))
            return root;
        if ((Integer) root.val > Math.max((Integer) q.val, (Integer) p.val)) return findLCARec(root.left, p, q);
        return root;
    }

    public static void main(String[] args) {
        TreeNode<Character> a = new TreeNode(5);
        TreeNode<Character> b = new TreeNode(3);
        TreeNode<Character> c = new TreeNode(6);
        TreeNode<Character> d = new TreeNode(1);
        TreeNode<Character> f = new TreeNode(2);
        TreeNode<Character> e = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.right = f;
        //      5
        //     / \
        //    3   6
        //   / \
        //  1   4
        //   \
        //    2

        Assert.assertEquals(b, findLCARec(a, e, f));
    }
}
