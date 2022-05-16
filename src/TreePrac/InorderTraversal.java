package TreePrac;

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

    // using iteration with stack
    public static List<Integer> inorderTraversalStack(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> currNode = root;
        while (currNode != null || !stack.empty()) {
            // traverse along the left edge to the bottom
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            // pop each node from the stack and add value to the list
            currNode = stack.pop();
            list.add(currNode.val);
            // push the right child of the node to the stack
            currNode = currNode.right;
        }
        return list;
    }

    // Above method can also be written as follows
    public static List<Integer> inorderTraversalIter2(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> currNode = root;
        while(currNode!=null || !stack.empty()){
            // traverse along the left edge to the bottom
            if (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                // pop each node from the stack and add value to the list
                currNode = stack.pop();
                list.add(currNode.val);
                // push the right child node if exists
                currNode = currNode.right;
            }
        }
        return list;
    }

    public static ArrayList<Integer> inOrderTraversalRec(TreeNode<Integer> root) {
        ArrayList<Integer> li = new ArrayList<>();
        helperRecusion(root, li);
        return li;
    }

    private static void helperRecusion(TreeNode<Integer> root, ArrayList<Integer> li) {
        if (root == null) return;
        helperRecusion(root.left, li);
        li.add(root.val);
        helperRecusion(root.right, li);
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
        Assert.assertEquals("[5, 4, 1, 3, 2, 6]", Arrays.toString(inorderTraversalStack(a).toArray()));

        Assert.assertEquals("[5, 4, 1, 3, 2, 6]", Arrays.toString(inOrderTraversalRec(a).toArray()));
    }

}
