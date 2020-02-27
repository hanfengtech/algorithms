package tech.hanfeng.algorithms.tree

import java.util.*
import kotlin.collections.ArrayList

fun preorder(root : TreeNode) : ArrayList<Int> {

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
    while (!stack.empty()) {
        cur = stack.peek()
        list.add(cur.value)
        cur = stack.pop()

        if (cur.right != null) {
            stack.push(cur.right)
        }

        if (cur.left != null) {
            stack.push(cur.left)
        }
    }

    return list
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
