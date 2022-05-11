package BSTPrac;

import org.junit.Assert;

import java.util.*;

public class prac {
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        TreeNode<Integer> p = root;
        queue.addFirst(p);
        while (!queue.isEmpty()) {
            ArrayList<Integer> eachList = new ArrayList<>();
            int heightNum = queue.size();
            for (int i = 0; i < heightNum; i++) {
                p = queue.removeLast();
                eachList.add(p.val);
                if (p.left != null) queue.addFirst(p.left);
                if (p.right != null) queue.addFirst(p.right);
            }
            result.add(eachList);
        }
        return result;
    }

    public static List<List<Integer>> levelOrderRecursion(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    private static void helper(TreeNode<Integer> node, List<List<Integer>> result, int height) {
        if (node == null) return;
        if (result.size() == height) result.add(new ArrayList<>());
        result.get(height).add(node.val);
        helper(node.left, result, height + 1);
        helper(node.right, result, height + 1);
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
        Assert.assertEquals("[[1], [4, 2], [5, 3, 6]]", Arrays.toString(levelOrderRecursion(a).toArray()));
    }
}
