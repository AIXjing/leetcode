package TreePrac;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;

public class Symmetric {
    public static boolean isSymmetric(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> deque = new LinkedList<>();
        if (root == null) return true;
        deque.add(root.left); // LinkedList.add() appends element to the end
        deque.add(root.right);
        while (deque.size() > 1) {
            TreeNode<Integer> left = deque.poll(); // retrieve and remove the head
            TreeNode<Integer> right = deque.poll();
            if ((left == null && right != null) || (right == null && left != null)) return false;
            else if (left == null && right == null) continue;
            else if (left.val != right.val) return false;
            deque.add(left.left);
            deque.add(right.right);
            deque.add(left.right);
            deque.add(right.left);
        }
        return true;
    }

    public static boolean isSymmetricRec(TreeNode<Integer> root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private static boolean helper(TreeNode<Integer> left, TreeNode<Integer> right) {
        if ((left == null && right != null) || (right == null && left != null)) return false;
        else if (left == null && right == null) return true;
        return (left.val == right.val)
                && helper(left.left, right.right)
                && helper(left.right, right.left);
    }

    public static void main(String[] args) {
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
        Assert.assertEquals(false, isSymmetric(a));
        Assert.assertEquals(false, isSymmetricRec(a));
    }
}
