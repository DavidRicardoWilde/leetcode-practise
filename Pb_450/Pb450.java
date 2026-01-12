package Pb_450;

import help.*;

public class Pb450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // found the node to be deleted
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                root.val = getRightMinVal(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
    }

    public int getRightMinVal(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        int minVal = node.val;
        node = null;
        return minVal;
    }
}