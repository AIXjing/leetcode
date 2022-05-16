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
    public static List<Integer> preorderTraversalIter2(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                list.add(node.val); // add to the list once traverse on it
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return list;
    }


    public static ArrayList<Integer> preOrderTraversalStack(TreeNode<Integer> root) {
        // create a new ArrayList to store values
        ArrayList<Integer> li = new ArrayList<>();
        if (root == null) return li;
        // as it is DFT, uses stack
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            // add node value to the list before push child nodes to the stack
            li.add(node.val);
            // due to FILO manner, push right child node in order to get the left child node
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return li;
    }

    public static ArrayList<Integer> preOrderTraversalRec(TreeNode<Integer> root) {
        // create a new ArrayList to store values
        ArrayList<Integer> li = new ArrayList<>();
        if (root == null) return li;
        helperRecursion(root, li);
        return li;
    }

    private static void helperRecursion(TreeNode<Integer> root, ArrayList<Integer> li) {
        if (root == null) return;
        // Step 1: add node value to the list
        li.add(root.val);
        // Step 2: go left
        helperRecursion(root.left, li);
        // Step 3: go right
        helperRecursion(root.right, li);
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
        Assert.assertEquals("[1, 4, 5, 2, 3, 6]", Arrays.toString(preorderTraversalIter2(a).toArray()));

        Assert.assertEquals("[1, 4, 5, 2, 3, 6]", Arrays.toString(preOrderTraversalStack(a).toArray()));
        Assert.assertEquals("[1, 4, 5, 2, 3, 6]", Arrays.toString(preOrderTraversalRec(a).toArray()));
    }
}
