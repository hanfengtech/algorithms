package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree

fun binaryTreePaths(root : TreeNode?) : ArrayList<String> {
    val answer = ArrayList<String>()
    if (root != null)
        constructPath(root, "", answer)

    return answer
}

fun constructPath(root : TreeNode, path : String, answer : ArrayList<String>) {
    if (root.left == null && root.right == null)
        answer.add(path + root.value)

    if (root.left != null) {
        constructPath(root.left!!, path + root.value + "->", answer)
    }

    if (root.right != null) {
        constructPath(root.right!!, path + root.value + "->", answer)
    }
}

fun main() {
    print(binaryTreePaths(populateTree()))
}