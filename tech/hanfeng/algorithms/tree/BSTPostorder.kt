package tech.hanfeng.algorithms.tree

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

fun postOrder(root : TreeNode?) : List<Int> {
    val list = LinkedList<Int>()
    val stack = Stack<TreeNode>()
    var cur = root

    while(stack.isNotEmpty() || cur != null) {
        if (cur != null) {
            stack.push(cur)
            list.addFirst(cur.value)
            cur = cur.right
        } else {
            val node = stack.pop()
            cur = node.left
        }
    }

    return list
}

fun main() {
    val tree = populateTree()
    print("Post-Order: ")
    print(postOrderRec(tree))
    print("\nPost-Order: ")
    print(postOrder(tree))
}