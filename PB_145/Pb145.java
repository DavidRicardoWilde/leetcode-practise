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

    public List<Integer> postorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if  (root == null) return result;

        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> helpStack = new LinkedList<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            helpStack.push(node);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) stack.push(node.right);
        }

        while(!helpStack.isEmpty()) {
            TreeNode node = helpStack.pop();
            result.add(node.val);
        }

        return result;
    }
}