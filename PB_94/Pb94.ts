import { TreeNode } from '../help/TreeNode';

function inorderTraversal(root: TreeNode | null): number[] {
    var result: number[] = []
    inorderTraversalRecursion(root, result)

    return result
};

function inorderTraversalRecursion(node: TreeNode, arr: number[]) {
    if  (node === null) {
        return
    }

    inorderTraversalRecursion(node.left, arr)
    arr.push(node.val)
    inorderTraversalRecursion(node.right, arr)
}