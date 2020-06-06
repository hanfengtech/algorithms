package tech.hanfeng.algorithms.tree

import kotlin.collections.ArrayList

data class SaleNode(var cost : Int, var chidren : ArrayList<SaleNode>? = null)

fun salesPath(root : SaleNode?) : Int {
    var min = Int.MAX_VALUE

    fun helper(node : SaleNode?, sum : Int) {
        if (node == null) return

        if (node.chidren == null) {
            min = Math.min(min, sum)
            return
        }

        node.chidren?.forEach{
            helper(it, it.cost + sum)
        }
    }

    helper(root, 0)
    return min
}

fun main() {

    val l21 = SaleNode(4)

    val l11 = SaleNode(5, arrayListOf(l21))


    val l32 = SaleNode(5)

    val l13 = SaleNode(3, arrayListOf(l32))

    val n1 = SaleNode(0, arrayListOf(l11, l13))

    println(salesPath(n1))
}
