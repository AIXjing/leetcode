package TreePrac;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ValidBST {

    // using recursion: runtime growth is O(log(n)) but may cause stack issue
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if ((Integer) root.val >= maxValue || (Integer) root.val <= minValue) return false;
        return isValidBST(root.left, minValue, (Integer) root.val) && isValidBST(root.right, (Integer) root.val, maxValue);
    }

    // Iteration using stack
    public static boolean isValidBSTIte(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root ;
        TreeNode pre = null ;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left ;
            } else {
                TreeNode p = stack.pop() ;
                if (pre != null && (Integer) p.val <= (Integer) pre.val) {
                    return false ;
                }
                pre = p ;
                cur = p.right ;
            }
        }
        return true ;
    }

    public static void main(String[] args) {
        TreeNode<Character> a = new TreeNode(5);
        TreeNode<Character> b = new TreeNode(3);
        TreeNode<Character> c = new TreeNode(7);
        TreeNode<Character> d = new TreeNode(1);
        TreeNode<Character> f = new TreeNode(8);
        TreeNode<Character> e = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        //      5
        //     / \
        //    3   7
        //   / \   \
        //  1   4   8

        Assert.assertEquals(true, isValidBST(a));
        Assert.assertEquals(true, isValidBSTIte(a));
    }
}
