package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
    var list1 = inOrderTraverse(root1, ArrayList())
    var list2 = inOrderTraverse(root2, ArrayList())
    return doMerge(list1, list2)
}

fun doMerge(list1 : ArrayList<Int>, list2 : ArrayList<Int>) : List<Int> {
    var result = ArrayList<Int>()

    var i = 0
    var j = 0

    while (i < list1.size && j < list2.size) {
         if (list1[i] < list2[j]) {
             result.add(list1[i++])
         } else {
             result.add(list2[j++])
         }
    }

    while (i < list1.size) {
        result.add(list1[i])
    }

    while (j < list2.size) {
        result.add(list2[j])
    }

    return result
}


fun inOrderTraverse(node : TreeNode?, list : ArrayList<Int>) : ArrayList<Int> {
    if (node == null) return list
    inOrderTraverse(node.left, list)
    list.add(node.value)
    inOrderTraverse(node.right, list)
    return list
}


fun getAllElementsIt(root1: TreeNode?, root2: TreeNode?): List<Int> {
    var stack1 = LinkedList<TreeNode>()
    var stack2 = LinkedList<TreeNode>()
    var res = ArrayList<Int>()
    var cur1 = root1
    var cur2 = root2

    while(cur1 != null || cur2 != null || stack1.isNotEmpty() || stack2.isNotEmpty()) {
        while(cur1 != null) {
            stack1.push(cur1)
            cur1 = cur1.left
        }

        while(cur2 != null) {
            stack2.push(cur2)
            cur2 = cur2.left
        }

        if (stack2.isEmpty() || stack1.isNotEmpty() && stack1.peek().value < stack2.peek().value) {
            cur1 = stack1.pop()
            res.add(cur1.value)
            cur1 = cur1.right
        } else {
            cur2 = stack2.pop()
            res.add(cur2.value)
            cur2 = cur2.right
        }
    }

    return res
}



