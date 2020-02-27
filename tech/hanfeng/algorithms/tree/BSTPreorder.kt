package tech.hanfeng.algorithms.tree

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

fun preorderPretty(root: TreeNode?) {
    fun helper(root: TreeNode?, level : Int) {

        if (root == null) return

        if (level > 0) {
            for (i in 1 until level) {
                print("   ")
            }

            for (i in (level - 1) until level) {
                print(" |--")
            }
        }

        print("${root.value} ")
        println()
        if (root.left != null) {
            helper(root.left, level + 1)
        }

        if (root.right != null) {
            helper(root.right, level + 1)
        }
    }

    helper(root, 0)
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