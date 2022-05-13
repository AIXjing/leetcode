/**
 * @source: https://leetcode.com/problems/path-sum/
 * @description:
 *  Given the root of a binary tree and an integer targetSum,
 *  return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 */

package TreePrac;

import org.junit.Assert;

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == (Integer) root.val;
        return hasPathSum(root.left, (targetSum - (Integer) root.val))
                || hasPathSum(root.right, targetSum - (Integer) root.val);
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
        Assert.assertEquals(true, hasPathSum(a, 6));
    }
}
