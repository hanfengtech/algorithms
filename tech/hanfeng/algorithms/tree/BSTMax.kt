package tech.hanfeng.algorithms.tree

fun bstMax(root : TreeNode?) : Int {

    if (root == null) return Int.MAX_VALUE

    var cur = root

    while(cur!!.right != null) {
        cur = cur.right
    }

    return cur.value
}

fun main() {
    var tree : TreeNode?
    tree = populateTree()
    println(bstMax(tree))
    println(bstMax(TreeNode(1)))
    tree = null
    println(bstMax(tree))
}