package trees;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

//        System.out.println("InorderTraversal Output");
//        System.out.println(inorderTraversal(root));
//        System.out.println();
//
//        System.out.println("PreOrderTraversal Output");
//        System.out.println(preOrderTraversal(root));
//        System.out.println();

        System.out.println("PostOrderTraversal Output");
        System.out.println(postOrderTraversal(root));
        System.out.println();
    }
    /*
    Below are the logic for iterative traversals of Binary Tree Data Structures
     */
    public static ArrayList<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.pop();
            result.add(current.val);

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }

        return result;
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }

    public static ArrayList<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                // The variable temp ensures that we check the right
                // of the current node before deciding to process
                // the left node
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    result.add(temp.val);
                    // if we are at the right of the root node, and that node is the
                    // last node on the right of root node, then we process the node
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        result.add(temp.val);
                    }
                } else {
                    current = temp;
                }
            }
        }
        return result;
    }
}
