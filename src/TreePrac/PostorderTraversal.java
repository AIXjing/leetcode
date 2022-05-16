package TreePrac;

import org.junit.Assert;

import java.util.*;

/**
 * @source: https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
class PostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
            result.add(root.val);
        }
        return result;
    }

    // traditional iteration method
    public static List<Integer> postorderTraversalStack(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        LinkedList<Integer> li = new LinkedList<>();
        TreeNode<Integer> node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // unlike inorder traversal, here we only "peek" the node in the stack
            // as we need to check if it has right child node
            node = stack.peek();
            // if it has, then traverse to the right child node
            if (node.right != null) {
                node = node.right;
            } else {
                // if it does not have, add this node value to the list
                node = stack.pop();
                li.add(node.val);
                // check if this node is a right child node
                // if it is, pop out the node and add the value to the list
                while (!stack.isEmpty() && node == stack.peek().right) {
                    node = stack.pop();
                    li.add(node.val);
                }
                node = null;
            }
        }
        return li;
    }

    // Iteration based on reverse preorder traversal method
    public static List<Integer> postorderTraversalStackRev(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        LinkedList<Integer> li = new LinkedList<>();
        TreeNode<Integer> node = root;
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                // to reverse preorder traversal,
                // add the value of each node traversed to the head of the list
                li.addFirst(node.val);
                // until the right side bottom
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        return li;
    }

    public static List<Integer> postorderTraversalRec(TreeNode<Integer> root) {
        List<Integer> li = new ArrayList<>();
        helperRecursion(root, li);
        return li;
    }

    private static void helperRecursion(TreeNode<Integer> root, List<Integer> li) {
        if (root == null) return;
        helperRecursion(root.left, li);
        helperRecursion(root.right, li);
        li.add(root.val);
    }


    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode(1);
        TreeNode<Integer> b = new TreeNode(2);
        TreeNode<Integer> c = new TreeNode(3);
        TreeNode<Integer> d = new TreeNode(4);
        TreeNode<Integer> e = new TreeNode(5);
        TreeNode<Integer> f = new TreeNode(6);
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
        Assert.assertEquals("[5, 4, 3, 6, 2, 1]", Arrays.toString(postorderTraversalRec(a).toArray()));
//        Assert.assertEquals("[5, 4, 3, 6, 2, 1]", Arrays.toString(postorderTraversalStack(a).toArray()));
        Assert.assertEquals("[5, 4, 3, 6, 2, 1]", Arrays.toString(postorderTraversalStack(a).toArray()));
    }
}
