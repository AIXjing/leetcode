package TreePrac;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxDepth {
    public static int maxDepthIte(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        queue.addFirst(p);
        int height = 0;
        while (!queue.isEmpty()) {
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                p = queue.removeLast();
                if (p.left != null) queue.addFirst(p.left);
                if (p.right != null) queue.addFirst(p.right);
            }
            height += 1;
        }
        return height;
    }

    public static int maxDepthRec(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepthRec(root.left);
        int right = maxDepthRec(root.right);
        return Math.max(left,right) + 1;
    }

    public static void main(String[] args){
        TreeNode<Integer> a = new TreeNode<>(1);
        TreeNode<Integer> b = new TreeNode<>(2);
        TreeNode<Integer> c = new TreeNode<>(3);
        TreeNode<Integer> d = new TreeNode<>(4);
        TreeNode<Integer> e = new TreeNode<>(5);
        TreeNode<Integer> f = new TreeNode<>(6);
        a.left = b;
        a.right = c;
        b.left= d;
        b.right = e;
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5
        Assert.assertEquals(3, maxDepthIte(a));
        Assert.assertEquals(3, maxDepthRec(a));
    }
}
