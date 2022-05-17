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

    // read all nodes in each level - iterative
    public static List<List<Integer>> levelOrderLists(TreeNode<Integer> root) {
        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>(); // a queue to place each node traversed
        if (root == null) return results;
        TreeNode<Integer> node = root;
        // add a variable to track level
        queue.add(node);
        while (!queue.isEmpty()) {
            List<Integer> li = new ArrayList<>();
            int level = queue.size();
            // add the value of the nodes in certain level to the corresponding list
            for (int i = 0; i < level; i++) {
                node = queue.remove();
                li.add(node.val);
                // if the node has child nodes, then add the child node to the queue and increase the level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            results.add(li);
        }
        return results;
    }

    // read all nodes in each level - recursive
    public static List<List<Integer>> levelOrderListsRec(TreeNode<Integer> root) {
        List<List<Integer>> results = new ArrayList<>();
        helperListsRec(root, results, 0);
        return results;
    }

    private static void helperListsRec(TreeNode<Integer> root, List<List<Integer>> results, int level) {
        if (root == null) return;
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        helperListsRec(root.left, results, level + 1);
        helperListsRec(root.right, results, level + 1);
    }

    public static List<Integer> levelOrderStack(TreeNode<Integer> root) {
        List<Integer> li = new ArrayList<>();
        if (root == null) return li;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        TreeNode<Integer> node = root;
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            li.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return li;
    }

    public static List<Integer> levelOrderRec(TreeNode<Integer> root) {
        List<Integer> li = new ArrayList<>();
        helperRecursion(root, li);
        return li;
    }

    private static void helperRecursion(TreeNode<Integer> root, List<Integer> li) {
        if (root == null) return;
        li.add(root.val);
        helperRecursion(root.left, li);
        helperRecursion(root.right, li);
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
        Assert.assertEquals("[1, 4, 2, 5, 3, 6]", Arrays.toString(levelOrderStack(a).toArray()));
        Assert.assertEquals("[1, 4, 2, 5, 3, 6]", Arrays.toString(levelOrderRec(a).toArray()));
//        Assert.assertEquals("[[1], [4, 2], [5, 3, 6]]", Arrays.toString(levelOrder(a).toArray()));
        Assert.assertEquals("[[1], [4, 2], [5, 3, 6]]", Arrays.toString(levelOrderRecursion(a).toArray()));
        Assert.assertEquals("[[1], [4, 2], [5, 3, 6]]", Arrays.toString(levelOrderLists(a).toArray()));
        Assert.assertEquals("[[1], [4, 2], [5, 3, 6]]", Arrays.toString(levelOrderListsRec(a).toArray()));
    }
}
