public class Pb144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalRecursion(root, result);

        return result;
    }

    public void preorderTraversalRecursion(TreeNode node, List list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        preorderTraversalRecursion(node.left, list);
        preorderTraversalRecursion(node.right, list);
    }
}