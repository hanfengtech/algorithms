package tech.hanfeng.algorithms.tree.utils

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
