package tech.hanfeng.algorithms.tree.utils

import tech.hanfeng.algorithms.tree.insert

fun populateTree() : TreeNode {
    var bst = insert(null, 44)
    bst = insert(bst, 17)
    bst = insert(bst, 88)
    bst = insert(bst, 8)
    bst = insert(bst, 32)
    bst = insert(bst, 28)
    bst = insert(bst, 29)
    bst = insert(bst, 65)
    bst = insert(bst, 54)
    bst = insert(bst, 82)
    bst = insert(bst, 76)
    bst = insert(bst, 68)
    bst = insert(bst, 80)
    bst = insert(bst, 97)
    bst = insert(bst, 93)
    return bst
}

fun popoluateSymmetricTree() : TreeNode {

    var node = TreeNode(1)
    node.left = TreeNode(2)
    node.left!!.left = TreeNode(3)
    node.left!!.right = TreeNode(4)
    node.right = TreeNode(2)
    node.right!!.left = TreeNode(4)
    node.right!!.right = TreeNode(3)

    return node
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
