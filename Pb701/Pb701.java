package Pb701;

import help.TreeNode;

public class Pb701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;

        while(current != null) {
            if (val == current.val) {
                break;
            }
            else if (val < current.val) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(val);
                    break;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }
}