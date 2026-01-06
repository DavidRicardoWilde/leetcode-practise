public class Pb145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalRecursion(root, result);
        return result;
    }

    public void postorderTraversalRecursion(TreeNode node, List list) {
        if (node == null) {
            return;
        }

        postorderTraversalRecursion(node.left, list);
        postorderTraversalRecursion(node.right, list);
        list.add(node.val);
    }
}