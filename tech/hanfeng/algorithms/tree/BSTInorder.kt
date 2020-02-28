package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import java.util.*
import kotlin.collections.ArrayList

fun inorderRec(root : TreeNode) : ArrayList<Int> {

    val list = ArrayList<Int>()

    fun dfs(root: TreeNode?) {

        if (root == null) return

        if (root.left != null) {
            dfs(root.left)
        }

        list.add(root.value)

        if (root.right != null) {
            dfs(root.right)
        }
    }

    dfs(root)
    return list
}

fun inOrder(root : TreeNode?) : List<Int>? {
    if (root == null) return null

    val result = ArrayList<Int>()
    val stack = Stack<TreeNode>()
    var cur = root

    while (cur != null || stack.isNotEmpty()) {
        if (cur != null) {
            stack.push(cur)
            cur = cur.left
        } else {
            cur = stack.pop()
            result.add(cur.value)
            cur = cur.right
        }
    }

    return result
}

fun main() {
    val tree = populateTree()

    print("In-order: ")
    print(inorderRec(tree))

    print("\nIn-order: ")
    print(inOrder(tree))

    print("\nIn-order: ")
    print(inOrder(null))
}