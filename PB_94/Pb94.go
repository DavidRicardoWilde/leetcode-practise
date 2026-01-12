package main

func inorderTraversal(root *TreeNode) []int {
	result := make([]int, 0)
	inorderTraversalRecursion(root, &result)

	return result
}

func inorderTraversalRecursion(root *TreeNode, result *[]int) {
	if nood != nil {
		inorderTraversalRecursion(root.Left, result)
		*result = append(*list, result.Val)
		inorderTraversalRecursion(root.Right, result)
	}
}