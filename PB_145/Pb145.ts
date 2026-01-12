import { TreeNode } from '../help/TreeNode';

function postorderTraversal(root: TreeNode | null): number[] {
    var result: number[] = [];
    postorderTraversalRecursion(root, result);
    return result;
};

function postorderTraversalRecursion(node: TreeNode | null, arr: number[]): void {
    if (node === null) {
        return;
    }
    postorderTraversalRecursion(node.left, arr);
    postorderTraversalRecursion(node.right, arr);
    arr.push(node.val);
}

