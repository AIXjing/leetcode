/**
 * @source: https://www.youtube.com/watch?v=fAAZixBzIAI
 * @description: detailed explanation to binary tree
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class BSTOrderPractice {

    public static List<Character> depthFirstTraversal_Recursion(TreeNode<Character> node) {
        List<Character> list = new ArrayList<>();
        if (node != null) {
            list.add(node.val);
            list.addAll(depthFirstTraversal_Recursion(node.left));
            list.addAll(depthFirstTraversal_Recursion(node.right));
        }
        return list;
    }

    public static List<Character> depthFirstTraversal_Iteration(TreeNode<Character> node) {
        Stack<TreeNode<Character>> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        stack.push(node);
        while (!stack.empty()) {
            TreeNode<Character> currNode = stack.pop();
            list.add(currNode.val);
            if (currNode.right != null) stack.push(currNode.right);
            if (currNode.left != null) stack.push(currNode.left);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode<Character> a = new TreeNode('a');
        TreeNode<Character> b = new TreeNode('b');
        TreeNode<Character> c = new TreeNode('c');
        TreeNode<Character> d = new TreeNode('d');
        TreeNode<Character> f = new TreeNode('f');
        TreeNode<Character> e = new TreeNode('e');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        System.out.println("Depth First Value using Iteration: "
                + Arrays.toString(depthFirstTraversal_Iteration(a).toArray()));

        System.out.println("Depth First Value using Recursion: "
                + Arrays.toString(depthFirstTraversal_Recursion(a).toArray()));
    }

    // Definition for a binary tree node.
    private static class TreeNode<T> {
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
