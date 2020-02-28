package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import java.util.*
import kotlin.collections.ArrayList

fun postOrderRec(root : TreeNode?) : ArrayList<Int>? {
    if (root == null) return null

    val list = ArrayList<Int>()

    fun dfs(root: TreeNode?) {
        if (root == null) return

        if (root.left != null) {
            dfs(root.left)
        }

        if (root.right != null) {
            dfs(root.right)
        }

        list.add(root.value)
    }

    dfs(root)
    return list
}

fun postOrder(root: TreeNode?) : List<Int>? {
    if (root == null) return null

    val result = LinkedList<Int>()
    val stack = Stack<TreeNode>()
    var cur = root

    while(cur != null || stack.isNotEmpty()) {
        if (cur != null) {
            result.addFirst(cur.value)
            stack.push(cur)
            cur = cur.right
        } else {
            cur = stack.pop()
            cur = cur.left
        }
    }

    return result
}

fun main() {
    val tree = populateTree()
    print("Post-Order: ")
    print(postOrderRec(tree))
    print("\nPost-Order: ")
    print(postOrder(tree))
    print("\nPost-Order: ")
    print(postOrder(null))
}