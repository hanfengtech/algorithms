package tech.hanfeng.algorithms.tree

fun searchR(root : TreeNode?, target : Int) : TreeNode? {
    if (root == null) return null

    if (root.value == target) return root

    if (root.left != null) {
        val result = searchR(root.left, target)

        if (result != null) {
            return result
        }
    }

    return searchR(root.right, target)
}

fun search(root : TreeNode?, target : Int) : TreeNode? {
    var cur = root

    while (cur != null) {
        if (target == cur.value) {
            return cur
        } else if (target < cur.value) {
            cur = cur.left
        } else {
            cur = cur.right
        }
    }

    return cur
}


fun main() {
    val root = TreeNode(44)

    // Left
    root.left = TreeNode(17)

    root.left?.left = TreeNode(8)
    root.left?.right = TreeNode(32)

    root.left?.right?.left = TreeNode(28)
    root.left?.right?.left?.right = TreeNode(29)

    // Right
    root.right = TreeNode(88)

    root.right?.left = TreeNode(65)
    root.right?.left?.left = TreeNode(54)

    root.right?.left?.right = TreeNode(82)
    root.right?.left?.right?.left = TreeNode(76)

    root.right?.left?.right?.left?.right = TreeNode(80)

    root.right?.right = TreeNode(97)
    root.right?.right?.left = TreeNode(93)

    println(searchR(root, 93))
    println(search(root, 29))
}