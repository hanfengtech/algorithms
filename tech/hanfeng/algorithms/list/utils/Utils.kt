package tech.hanfeng.algorithms.list.utils

import tech.hanfeng.algorithms.list.Node

fun printList(node : ListNode?) {
    if (node == null)
        return

    var cur = node
    if (cur.next !== null) {
        while (cur?.next != null) {
            print("${cur?.value} -> ")
            cur = cur?.next
        }
    }
    print(cur?.value)
}