package tech.hanfeng.algorithms.tree

class TreeNode(var value : Int) {
    var left : TreeNode? = null
    var right : TreeNode? = null

    override fun toString(): String {
        return value.toString()
    }
}