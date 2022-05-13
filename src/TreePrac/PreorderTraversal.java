package TreePrac;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @source: https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
class PreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }

    // using Stack - method 1
    public static List<Integer> preorderTraversalStack(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        stack.push(root);
        while(!stack.empty()) {
            TreeNode<Integer> currNode = stack.pop();
            result.add(currNode.val);
            if (currNode.right != null) stack.push(currNode.right);
            if (currNode.left != null) stack.push(currNode.left);
        }
        return result;
    }

    // using iteration - method 2: using a pointer node and a parent node
    public static List<Integer> reorderTraversalIter2(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> currNode = root;
        while (currNode != null || !stack.empty()) {
            if (currNode != null) {
                stack.push(currNode);
                list.add(currNode.val); // add to the list once traverse on it
                currNode = currNode.left;
            } else {
                TreeNode<Integer> parentNode = stack.pop();
                currNode = parentNode.right;
            }
        }
        return list;
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
        System.out.println("Preorder Traversal using Recursion: "
                + Arrays.toString(preorderTraversal(a).toArray()));

        Assert.assertEquals("[1, 4, 5, 2, 3, 6]", Arrays.toString(preorderTraversalStack(a).toArray()));
        Assert.assertEquals("[1, 4, 5, 2, 3, 6]", Arrays.toString(reorderTraversalIter2(a).toArray()));
    }
}
