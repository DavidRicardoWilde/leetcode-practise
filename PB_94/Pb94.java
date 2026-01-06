public class P94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalRecursion(root, result);

        return result;
    }

    public void inorderTraversalRecursion(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inorderTraversalRecursion(node.left, list);
        list.add(node.val);
        inorderTraversalRecursion(node.right, list);
    }
}