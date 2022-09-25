package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    static boolean found = false;
    public static void main(String[] args) {
        // root = [2,1,3]
        // root = [1,2,3,4,5,null,7]

//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(5);


        search(root, 6, found);

        System.out.println(found);

//        String s = "4(2(3)(1))(6(5))";
//        TreeNode result = str2tree(s);
    }

    public static void search(TreeNode root, int key, boolean found) {

        if (root == null) return;

        if (root.val == key) {
            found = true;
            return;
        }


        search(root.left, key, found);
        search(root.right, key, found);
    }

    public static TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        // Input: s = "4(2(3)(1))(6(5))"
        // Output: [4,2,6,3,1,5]
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int idx = 0;
        int strLen = s.length();

        while (idx < strLen) {
            char c = s.charAt(idx);
            if (Character.isDigit(c) || c == '-') {
                int newStartIdx = idx;
                int newEndIdx = idx + 1;
                while (newEndIdx < strLen && Character.isDigit(s.charAt(newEndIdx))) {
                    newEndIdx++;
                }
                int nodeVal = Integer.parseInt(s.substring(newStartIdx, newEndIdx));
                TreeNode node = new TreeNode(nodeVal);

                // assuming we have a root in the stack already
                // then it's time to give it it's left and rigth
                // values.
                if (!stack.isEmpty()) {
                    TreeNode root = stack.peek();
                    if (root.left == null) {
                        root.left = node;
                    } else {
                        root.right = node;
                    }
                }

                stack.push(node);
                idx = newEndIdx;
                continue; // we are done processing digits, it time to move on.


            } else if (c == ')') {
                stack.pop();
            }

            idx++;
        }

        return stack.pop();
    }

    public static Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();


                if ( i < size - 1) {
                    node.next = q.peek();
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return root;
    }
    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};