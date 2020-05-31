package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populate123Tree
import java.util.*


fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
    var sum = 0

    fun helper(node : TreeNode?) {
        if (node == null) return

        helper(node.left)

        if (node.value == R) {
            sum += R
            return
        }

        if (node.value >= L) {
            sum += L
        }

        helper(node.right)
    }

    helper(root)
    return sum
}


var ans = 0
fun rangeSumBST2(root: TreeNode?, L: Int, R: Int): Int {
    ans = 0
    dfs(root, L, R)
    return ans
}

fun dfs(node: TreeNode?, L: Int, R: Int) {
    if (node != null) {
        if (node.value in L..R) ans += node.value
        if (L < node.value) dfs(node.left, L, R)
        if (node.value < R) dfs(node.right, L, R)
    }
}

fun dfsIt(node: TreeNode?, L: Int, R: Int) : Int {
    val stack = LinkedList<TreeNode>()
    var sum = 0
    if (node == null) return sum

    var cur = node
    while (cur != null) {
        stack.push(cur)
        cur = cur.left
    }

    while(stack.isNotEmpty()) {
        val n = stack.pop()
        if (n.value in L..R) {
            sum += n.value
        }

        if (n.right != null) {
            stack.push(n.right)
            cur = n.right?.left
            while(cur != null) {
                stack.push(cur)
                cur = cur.left
            }
        }
    }

    return sum
}


fun rangeSumBSTStack(root: TreeNode?, L: Int, R: Int): Int {
    var ans = 0
    val stack = LinkedList<TreeNode>()
    stack.push(root)
    while (!stack.isEmpty()) {
        val node = stack.pop()
        if (node != null) {
            if (node.value in L..R) ans += node.value
            if (node.left != null && L < node.value) stack.push(node.left)
            if (node.right != null && node.value < R) stack.push(node.right)
        }
    }
    return ans
}

fun main() {

    val t = TreeNode(7)
    t.left = TreeNode(4)
    t.right = TreeNode(10)


    t.left!!.left = TreeNode(1)
    t.left!!.left = TreeNode(6)



    //println(rangeSumBST2(t, 2, 3))
    println(rangeSumBSTStack(t, 6, 10))

}