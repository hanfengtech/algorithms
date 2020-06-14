package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import java.util.*


fun inorder(root: TreeNode?, nums: ArrayList<Int>) {
    if (root == null) return
    inorder(root.left, nums)
    nums.add(root.`val`)
    inorder(root.right, nums)
}

fun findTwoSwapped(nums: ArrayList<Int>): IntArray {
    val n = nums.size
    var x = -1
    var y = -1
    for (i in 0 until n - 1) {
        if (nums[i + 1] < nums[i]) {
            y = nums[i + 1]
            // first swap occurence
            x = if (x == -1) nums[i] else break
        }
    }
    return intArrayOf(x, y)
}

fun recover(r: TreeNode?, count: Int, x: Int, y: Int) {
    var count = count
    if (r != null) {
        if (r.`val` == x || r.`val` == y) {
            r.`val` = if (r.`val` == x) y else x
            if (--count == 0) return
        }
        recover(r.left, count, x, y)
        recover(r.right, count, x, y)
    }
}

fun recoverTree(root: TreeNode?) {
    val nums = ArrayList<Int>()
    inorder(root, nums)
    val swapped = findTwoSwapped(nums)
    recover(root, 2, swapped[0], swapped[1])
}


fun swap(a: TreeNode?, b: TreeNode?) {
    val tmp = a!!.`val`
    a.`val` = b!!.`val`
    b.`val` = tmp
}

fun recoverTreeIt(root: TreeNode?) {
    var root = root
    val stack: Deque<TreeNode> = ArrayDeque()
    var x: TreeNode? = null
    var y: TreeNode? = null
    var pred: TreeNode? = null
    while (!stack.isEmpty() || root != null) {
        while (root != null) {
            stack.add(root)
            root = root.left
        }
        root = stack.removeLast()
        if (pred != null && root.`val` < pred.`val`) {
            y = root
            x = if (x == null) pred else break
        }
        pred = root
        root = root.right
    }
    swap(x, y)
}


var x: TreeNode? = null
var y:TreeNode? = null
var pred:TreeNode? = null

fun findTwoSwapped(root: TreeNode?) {
    if (root == null) return
    findTwoSwapped(root.left)
    if (pred != null && root.`val` < pred!!.`val`) {
        y = root
        if (x == null) x = pred else return
    }
    pred = root
    findTwoSwapped(root.right)
}

fun recoverTreeRec(root: TreeNode?) {
    findTwoSwapped(root)
    swap(x, y)
}