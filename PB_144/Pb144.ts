function preorderTraversal(root: TreeNode | null): number[] {
    var result: number[] = []
    preorderTraversalRecusrion(root, result)

    return result
};

function preorderTraversalRecusrion(node: TreeNode, arr: number[]) {
    if (node === null) {
        return
    }

    arr.push(node.val)
    preorderTraversalRecusrion(node.left, arr)
    preorderTraversalRecusrion(node.right, arr)
}