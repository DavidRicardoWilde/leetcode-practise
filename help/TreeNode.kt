/**
 * LeetCode-style TreeNode helper for Kotlin (Int values).
 * Provides factory/serializer and common traversal helpers.
 * Example:
 *  val root = TreeNode.fromArray(1, 2, 3, null, 4)
 *  val list = TreeNode.toList(root) // level-order serialization
 */
package helpKt

class TreeNode(var `val`: Int) {
   var left: TreeNode? = null
   var right: TreeNode? = null

   override fun toString(): String = "TreeNode(`val`=$`val`)"

   companion object {
      /**
       * Build a tree from level-order list where `null` represents missing nodes.
       * Example: listOf(1, 2, 3, null, 4) ->
       *     1
       *    / \
       *   2   3
       *    \
       *     4
       */
      fun fromList(values: List<Int?>): TreeNode? {
         if (values.isEmpty() || values[0] == null) return null
         val root = TreeNode(values[0]!!)
         val queue: ArrayDeque<TreeNode> = ArrayDeque()
         queue.add(root)
         var i = 1
         while (i < values.size) {
            val node = queue.removeFirst()
            val leftVal = values[i++]
            if (leftVal != null) {
               val left = TreeNode(leftVal)
               node.left = left
               queue.add(left)
            }
            if (i < values.size) {
               val rightVal = values[i++]
               if (rightVal != null) {
                  val right = TreeNode(rightVal)
                  node.right = right
                  queue.add(right)
               }
            }
         }
         return root
      }

      /** Convenience vararg builder. */
      fun fromArray(vararg values: Int?): TreeNode? = fromList(values.toList())

      /** Serialize tree to level-order list trimming trailing nulls. */
      fun toList(root: TreeNode?): List<Int?> {
         val res = ArrayList<Int?>()
         val q: ArrayDeque<TreeNode?> = ArrayDeque()
         q.add(root)
         while (q.isNotEmpty()) {
            val node = q.removeFirst()
            if (node == null) {
               res.add(null)
            } else {
               res.add(node.`val`)
               q.add(node.left)
               q.add(node.right)
            }
         }
         var idx = res.size - 1
         while (idx >= 0 && res[idx] == null) idx--
         return if (idx < 0) emptyList() else res.subList(0, idx + 1)
      }
   }
}