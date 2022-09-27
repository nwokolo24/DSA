package trees;

import com.sun.source.tree.Tree;

import static trees.BinaryTreeTraversal.inorderTraversal;

public class InsertIntoBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        TreeNode val = insert(root, 100);
        System.out.println("InorderTraversal Output");
        System.out.println(inorderTraversal(root));
        System.out.println();
    }

    private static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.val) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }
}
