package Pb_700;

import help.TreeNode;

public class Pb700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;
        while(current != null) {
            if (current.val == val) {
                return current;
            } else if (val < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }
}