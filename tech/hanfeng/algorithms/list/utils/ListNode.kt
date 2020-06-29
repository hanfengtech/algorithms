package tech.hanfeng.algorithms.list.utils

import tech.hanfeng.algorithms.tree.processedNode

class ListNode(var value : Int) {
    var next : ListNode? = null
}

fun printList(node : ListNode) {
    var cur : ListNode? = node
    while (cur != null) {
        print(cur.value)
        if (cur.next != null)
            print("->")
        cur = cur.next
    }
}