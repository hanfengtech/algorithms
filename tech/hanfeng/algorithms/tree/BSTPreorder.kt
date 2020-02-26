package tech.hanfeng.algorithms.tree

import java.util.*

fun preorder(root : TreeNode) {
    dfs(root)
}

fun dfs(root: TreeNode?) {

    if (root == null) return

    print("${root.value} ")
    if (root.left != null) {
        dfs(root.left)
    }

    if (root.right != null) {
        dfs(root.right)
    }
}

fun dfsIt(root: TreeNode?) {
    if (root == null) return

    val stack = Stack<TreeNode>()
    var cur = root
    stack.push(cur)
    while (!stack.empty()) {
        cur = stack.peek()
        print("${cur.value} ")
        cur = stack.pop()

        if (cur.right != null) {
            stack.push(cur.right)
        }

        if (cur.left != null) {
            stack.push(cur.left)
        }
    }
}

fun preorderPretty(root: TreeNode?) {
    fun helper(root: TreeNode?, level : Int) {

        if (root == null) return

        if (level > 0) {
            for (i in 1 until level) {
                print("   ")
            }

            for (i in (level - 1) until level) {
                print("|--")
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
