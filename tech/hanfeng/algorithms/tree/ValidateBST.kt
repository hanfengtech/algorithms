package tech.hanfeng.algorithms.tree

var prevVal = Integer.MIN_VALUE

fun isValidateBST(root : TreeNode?) : Boolean {
    if (root == null) return true

    if (!isValidateBST(root.left)) return false

    if ( !(prevVal < root.value) ) return false

    prevVal = root.value

    return isValidateBST(root.right)
}

fun main() {
    val tree = populateTree()
    print(isValidateBST(tree))
}