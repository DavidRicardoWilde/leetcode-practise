package Pb_106;

import help.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Pb106 {
    private final Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helpBuildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode helpBuildTree(int[] postOrder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postOrder[pEnd]);
        int inRootPosition = inorderMap.getOrDefault(postOrder[pEnd], -1);
        int leftNodeCount = inRootPosition - iStart;

        root.left = helpBuildTree(postOrder, pStart, pStart + leftNodeCount - 1, inorder, iStart, inRootPosition - 1);
        root.right = helpBuildTree(postOrder, pStart + leftNodeCount, pEnd - 1, inorder, inRootPosition + 1, iEnd);

        return root;
    }
}