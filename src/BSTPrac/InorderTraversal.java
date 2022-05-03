package BSTPrac;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @source: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * similar to post-order traversal problem: https://leetcode.com/problems/binary-tree-postorder-traversal/
 */

public class InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        // Step 1: traverse left
        if (root.left != null) result.addAll(inorderTraversal(root.left));
        // Step 2: visit node
        result.add((Integer) root.val);
        // Step 3: traverse right
        if (root.right != null) result.addAll(inorderTraversal(root.right));
        return result;
    }

    // using iteration - method 1
    public static List<Integer> inorderTraversalIter(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        while(currNode!=null || !stack.empty()){
            while(currNode!=null){
                stack.add(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            list.add((Integer) currNode.val);
            currNode = currNode.right;
        }
        return list;
    }

    // using iteration - method 2: using a pointer node and a parent node
    public static List<Integer> inorderTraversalIter2(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> currNode = root;
        while(currNode!=null || !stack.empty()){
            if (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                TreeNode<Integer> parentNode = stack.pop();
                list.add(parentNode.val); // add after all left child
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
        Assert.assertEquals("[5, 4, 1, 3, 2, 6]", Arrays.toString(inorderTraversal(a).toArray()));
        Assert.assertEquals("[5, 4, 1, 3, 2, 6]", Arrays.toString(inorderTraversalIter2(a).toArray()));
    }

    // Definition for a binary tree node.
    static class TreeNode<T> {
        T val;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode() {}
        TreeNode(T val) { this.val = val; }
        TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
