package BSTPrac;

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

    // Iteration using Stack - method 1
    public static List<Integer> postorderTraversalStack(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push (curr.left);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add((Integer) curr.val);
        }
        return result;
    }

    // Iteration using Deque - method 2: reverse preorder traversal method
    public static List<Integer> postorderTraversalStack2(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        LinkedList<Integer> result = new LinkedList<>();
        TreeNode<Integer> currNode = root;
        while(currNode != null || !stack.isEmpty()) {
            if (currNode != null) {
                stack.push(currNode);
                result.addFirst(currNode.val);  // reverse the preorder traversal
                currNode = currNode.left;
            } else {
                TreeNode<Integer> parentNode = stack.pop();
                currNode = parentNode.right;
            }
        }
        return result;
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
        Assert.assertEquals("[5, 4, 3, 6, 2, 1]", Arrays.toString(postorderTraversal(a).toArray()));
        Assert.assertEquals("[5, 4, 3, 6, 2, 1]", Arrays.toString(postorderTraversalStack(a).toArray()));
    }
}
