package tech.hanfeng.algorithms.tree

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

fun inorder(root : TreeNode?) : ArrayList<Int>{

    val list = ArrayList<Int>()
    val stack = Stack<TreeNode>()
    var cur = root

    while (cur != null || !stack.empty()) {

        if (cur != null) {
            stack.push(cur)
            cur = cur.left
            continue
        }

        cur = stack.pop()
        list.add(cur.value)

        cur = cur.right
    }

    return list
}

fun main() {
    val tree = populateTree()

    print("In-order: ")
    print(inorderRec(tree).joinToString())

    print("\nIn-order: ")
    print(inorder(tree).joinToString())
}