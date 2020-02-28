package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import tech.hanfeng.algorithms.tree.utils.preorderPretty
import java.util.*
import kotlin.collections.ArrayList

fun preorderRec(root : TreeNode) : ArrayList<Int> {

    val list = ArrayList<Int>()

    fun dfs(root: TreeNode?) {

        if (root == null) return
        list.add(root.value)

        if (root.left != null) {
            dfs(root.left)
        }

        if (root.right != null) {
            dfs(root.right)
        }
    }

    dfs(root)

    return list
}


fun dfsIt(root: TreeNode?) : ArrayList<Int>? {
    if (root == null) return null

    val list = ArrayList<Int>()
    val stack = Stack<TreeNode>()
    var cur = root
    stack.push(cur)
    while (stack.isNotEmpty()) {
        cur = stack.pop()
        list.add(cur.value)

        if (cur.right != null) {
            stack.push(cur.right)
        }

        if (cur.left != null) {
            stack.push(cur.left)
        }
    }

    return list
}

fun preOrder(root:  TreeNode?) : List<Int>? {
    if (root == null) return null

    val result = LinkedList<Int>()
    val stack = Stack<TreeNode>()
    var cur = root

    while (cur != null || stack.isNotEmpty()) {
        if (cur != null) {
            result.add(cur.value)
            stack.push(cur)
            cur = cur.left
        } else {
            cur = stack.pop()
            cur = cur.right
        }
    }

    return result
}

fun main() {
    val tree = populateTree()
    print("\nPre-Order: ")
    print(preorderRec(tree))

    print("\nPre-Order: ")
    print(preOrder(tree))
    print("\nPre-Order: ")
    print(preOrder(null))
    println("\nPre-order: ")
    preorderPretty(tree)
}