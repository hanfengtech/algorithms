package tech.hanfeng.algorithms.tree

import java.util.*

class TreeToDoubleList {

    data class Node(var value: Int, var left : Node? = null, var right : Node? = null)
    fun treeToDoubleList(root: Node?): Node? {
        if (root == null) return root
        var stack = LinkedList<Node>()
        var curr = root
        var head = Node(0)
        var pre = head

        while(stack.isNotEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr)
                curr = curr.left
            }
            curr = stack.pop()
            var right = curr.right
            curr.left = pre
            pre.right = curr
            pre = curr
            curr = right
        }
        head.right?.left = pre
        pre.right = head.right
        return head.right
    }
}

