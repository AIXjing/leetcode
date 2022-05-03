package BSTPrac; /**
 * @source: https://www.youtube.com/watch?v=fAAZixBzIAI
 * @description: detailed explanation to binary tree
 */

import org.junit.Assert;

import java.util.*;


public class BSTOrderPractice {

    /* Depth-First-Values Traversal */
    public static List<Character> depthFirstTraversal_Recursion(TreeNode<Character> node) {
        List<Character> list = new ArrayList<>();
        if (node != null) {
            list.add(node.val);
            list.addAll(depthFirstTraversal_Recursion(node.left));
            list.addAll(depthFirstTraversal_Recursion(node.right));
        }
        return list;
    }

    // Iteration using stack
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

    /* Breadth-First-Values traversal */
    // using Queue - add element from the end, get element from the beginning and delete the first element
    // there is no way to implement breadth-first traversal using recursion
    public static List<Character> breadthFirstTraversal_Iteration(TreeNode<Character> node) {
        LinkedList<TreeNode<Character>> queue = new LinkedList<>();
        List<Character> list = new ArrayList<>();
        queue.addFirst(node);  // or use queue.add(node) and change the following statement correspondingly
        while (!queue.isEmpty()) {
            TreeNode<Character> currNode = queue.pollLast();  // queue.removeFirst()
            list.add(currNode.val);
            if (currNode.left != null) queue.addFirst(currNode.left);  // queue.add()
            if (currNode.right != null) queue.addFirst(currNode.right);  // queue.add()
        }
        return list;
    }

    // using recursion

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
        //      a
        //     / \
        //    b   c
        //   / \   \
        //  d   e   f

        System.out.println("Depth First Value using Iteration: "
                + Arrays.toString(depthFirstTraversal_Iteration(a).toArray()));
        System.out.println("Depth First Value using Recursion: "
                + Arrays.toString(depthFirstTraversal_Recursion(a).toArray()));

        Assert.assertEquals(
                "[a, b, d, e, c, f]",
                Arrays.toString(depthFirstTraversal_Iteration(a).toArray()));

        Assert.assertEquals(
                "[a, b, c, d, e, f]",
                Arrays.toString(breadthFirstTraversal_Iteration(a).toArray()));
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
