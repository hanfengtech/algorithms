package tech.hanfeng.algorithms.tree

fun isSymmetric(root : TreeNode?) : Boolean {

    fun isMirror(p : TreeNode?, q: TreeNode?) : Boolean {
        if (p == null && q == null) return true

        if (p == null || q == null) return false

        if (p.value != q.value) return false

        return isMirror(p.left, q.right) && isMirror(p.right, q.left)
    }

    if (root == null) return true

    return isMirror(root.left, root.right)
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

fun main() {

    var tree = populateTree()
    println(isSymmetric(tree))
    tree = popoluateSymmetricTree()
    println(isSymmetric(tree))
}