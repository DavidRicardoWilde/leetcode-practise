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

    // version 2
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

        }

        return result;
    }

    // v3
    public List<Integer> preorderTraversalV3(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                result.add(node.val);
                stack.push(node);

                node = node.left;
            }

            node = stack.pop();
            node = node.right;
        }

        return result;
    }
}