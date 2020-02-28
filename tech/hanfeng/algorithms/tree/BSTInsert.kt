package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import tech.hanfeng.algorithms.tree.utils.preorderPretty

fun insert(root : TreeNode?, x : Int) : TreeNode {

    var newNode = TreeNode(x)

    if (root == null) return newNode

    var cur : TreeNode? = root
    var prev : TreeNode? = null

    while (cur != null) {
        when {
            x == cur.value -> {
                throw Exception("Value already exist!")
            }
            x < cur.value -> {
                prev = cur
                cur = cur.left
            }
            x > cur.value -> {
                prev = cur
                cur = cur.right
            }
        }
    }

    if (x < prev!!.value) {
        prev.left = newNode
    } else {
        prev.right = newNode
    }

    return root
}

fun main() {
    var bst = populateTree()

    print("Pre-order: ")
    print(preOrder(bst))
    print("\nPre-order: ")
    print(dfsIt(bst))
    println("\nPre-order: ")
    preorderPretty(bst)
}

