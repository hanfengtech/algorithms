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

fun populateBalancedTree() : TreeNode {
    var node = TreeNode(1)
    node.left = TreeNode(2)
    node.left!!.left = TreeNode(4)
    node.left!!.right = TreeNode(5)
    node.left!!.right!!.left = TreeNode(7)
    node.right = TreeNode(3)
    node.right!!.right = TreeNode(6)

    return node
}

fun populatePathTree() : TreeNode {
    var node = TreeNode(5)
    node.left = TreeNode(4)
    node.left!!.left = TreeNode(11)
    node.left!!.left!!.left = TreeNode(7)
    node.left!!.left!!.right = TreeNode(2)

    node.right = TreeNode(8)
    node.right!!.left = TreeNode(13)
    node.right!!.right = TreeNode(4)
    node.right!!.right!!.left = TreeNode(5)
    node.right!!.right!!.right = TreeNode(1)

    return node
}

fun populate123Tree() : TreeNode {
    val tree = TreeNode(1)
    tree.left = TreeNode(2)
    tree.right = TreeNode(3)

    return tree
}