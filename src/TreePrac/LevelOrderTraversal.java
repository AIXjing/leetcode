package TreePrac;

import org.junit.Assert;

import java.util.*;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        List<List<Integer>> li = new ArrayList<>();
        Deque<TreeNode<Integer>> queue = new LinkedList<>(); // a queue to place each node traversed
        if (root == null) return li;
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            // use a variable to track which level
            int levelNum = queue.size();
            List<Integer> eachList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode<Integer> currNode = queue.removeLast();
                eachList.add(currNode.val);
                if (currNode.left != null) queue.addFirst(currNode.left);
                if (currNode.right != null) queue.addFirst(currNode.right);
            }
            li.add(eachList);
        }
        return li;
    }

    public static List<List<Integer>> levelOrderRecursion(TreeNode<Integer> root) {
        List<List<Integer>> li = new ArrayList<>();
        helper(li, root, 0);
        return li;
    }

    private static void helper(List<List<Integer>> li, TreeNode<Integer> root, int levelNum) {
        if (root == null) return;
        if (li.size() == levelNum) {
            li.add(new ArrayList<>());
        }
        li.get(levelNum).add(root.val);
        helper(li, root.left, levelNum + 1);
        helper(li, root.right, levelNum + 1);
    }

    public static List<Integer> levelOrderList(TreeNode<Integer> root) {
        List<Integer> li = new ArrayList<>();
        Deque<TreeNode<Integer>> queue = new LinkedList<>(); // a queue to place each node traversed
        if (root == null) return li;
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> currNode = queue.removeLast();
            li.add(currNode.val);
            if (currNode.left != null) queue.addFirst(currNode.left);
            if (currNode.right != null) queue.addFirst(currNode.right);
        }
        return li;
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
        Assert.assertEquals("[1, 4, 2, 5, 3, 6]", Arrays.toString(levelOrderList(a).toArray()));
        Assert.assertEquals("[[1], [4, 2], [5, 3, 6]]", Arrays.toString(levelOrder(a).toArray()));
        Assert.assertEquals("[[1], [4, 2], [5, 3, 6]]", Arrays.toString(levelOrderRecursion(a).toArray()));
    }
}
