package trees;

import com.sun.source.tree.Tree;

import static trees.BinaryTreeTraversal.inorderTraversal;

public class InsertIntoBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);

        TreeNode val = insert(root, 5);
        System.out.println("InorderTraversal Output");
        System.out.println(inorderTraversal(root));
        System.out.println();
    }

    private static TreeNode insert(TreeNode root, int value) {
        String Caller = root == null ? "Null" : String.valueOf(root.val);
        String CallerLeft = "";
        String CallerRight = "";
        if (root != null) {
            CallerLeft = root.left == null ? "Null" : String.valueOf(root.left.val);
            CallerRight = root.right == null ? "Null" : String.valueOf(root.right.val);
        }

        if (root == null) {
            String ValueToBeInserted = String.valueOf(value);
            root = new TreeNode(value);
            return root;
        }

        if (root.val > value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        String rootRight = root.right == null ? "Null" : String.valueOf(root.right.val);
        String rootsLeft = root.left == null ? "Null" : String.valueOf(root.left.val);
        return root;
    }
}
