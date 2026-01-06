// Swift TreeNode
// Simple binary tree node used in LeetCode-style problems
public class TreeNode<T> {
    public var val: T
    public var left: TreeNode?
    public var right: TreeNode?

    public init() {self.val = T.self as! T; self.left = nil; self.right = nil}
    public init(_ val： Int) {
        self.val = val
        self.left = nil
        self.right = nil
    }
    public init(_ val: Int, _ left: TreeNode? = nil, _ right: TreeNode? = nil) {
        self.val = val
        self.left = left
        self.right = right
    }
}
