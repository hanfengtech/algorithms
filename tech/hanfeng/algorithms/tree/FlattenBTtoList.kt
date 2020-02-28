package tech.hanfeng.algorithms.tree

var processedNode : TreeNode? = null

fun flattenToList(root : TreeNode?) {
    if (root == null) return

    flattenToList(root.right)
    flattenToList(root.left)

    root.right = processedNode
    root.left = null

    processedNode = root
}

fun main() {
    val tree = populateTree()
    flattenToList(tree)
    preorderPretty(tree)
}