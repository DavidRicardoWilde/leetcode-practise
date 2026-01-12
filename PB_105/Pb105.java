package PB_105;

import help.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Pb105 {
    private final Map<Integer, Integer> inorderMap = new HashMap<>();

     public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

         for (int i = 0; i < inorder.length - 1; i++) {
             inorderMap.put(inorder[i], i);
         }

        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

//        int inRootPosition = findRootPositonInInorder(inorder, preorder[preStart]);
        int inRootPosition = inorderMap.getOrDefault(preorder[preStart], -1);
        int leftNodeCount = inRootPosition - inStart;

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftNodeCount, inorder, inStart, inRootPosition - 1 );
        root.right = buildTreeHelper(preorder, preStart + leftNodeCount + 1, preEnd, inorder, inRootPosition + 1, inEnd);

        return root;

    }

    public int findRootPositonInInorder(int[] inorder, int val) {
        for (int i = 0; i < inorder.length-1; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }

        return -1;
    }
}