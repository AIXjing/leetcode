/**
 * @source:
 */
package TreePrac;

import org.junit.Assert;

import java.util.*;

public class TwoSumBST {

    /*
    my method:
    simply store all the node values in an arrayList and check if two elements exist
    Time Complexity: O(n*2 + n); Space Complexity: O(n)
    */
    public static boolean findTarget(TreeNode root, int k) {
        // store all node value in an arrayList
        List<Integer> list = new ArrayList<>();
        // to pass each node
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) return false;
        if (root.left == null && root.right == null) return false;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            list.add((Integer) p.val);
            if (p.right != null) stack.push(p.right);
            if (p.left != null) stack.push(p.left);
        }

        int len = list.size();
        for (int i = 0; i < len - 1; i++) {
            int resid = k - list.get(i);
            for (int j = i + 1; j < len; j++) {
                if (list.get(j) == resid) return true;
            }
        }
        return false;
    }

    /*
       using a hashtable:
       everytime insert a value into the hashtable, check if hashtable contains k - node.val
       Time complexity: O(n), Space complexity: O(n)
    */
    public static boolean findTargetHashSet(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private static boolean dfs(TreeNode node, HashSet<Integer> set, int k) {
        if (node == null) return false;
        if (set.contains(k - (Integer) node.val)) return true;
        set.add((Integer) node.val);
        return dfs(node.left, set, k) || dfs(node.right, set, k);
    }

    public static boolean findTargetQueue(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return false;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - (Integer) node.val)) return true;
            set.add((Integer) node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return false;
    }

    public static boolean findTargetStack(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return false;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (set.contains(k - (Integer) node.val)) return true;
            set.add((Integer) node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return false;
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

        Assert.assertEquals(true, findTarget(a, 12));
        Assert.assertEquals(true, findTargetQueue(a, 12));
        Assert.assertEquals(true, findTargetHashSet(a, 12));
    }
}
