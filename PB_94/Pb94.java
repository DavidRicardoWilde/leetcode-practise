public class P94 {
    // version 1
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


    // v2
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            result.add(node.val);

            node = node.right;
        }

        return result;
    }
}
