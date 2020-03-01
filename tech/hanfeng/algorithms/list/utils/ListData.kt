package tech.hanfeng.algorithms.list.utils

fun populateCycleList() : ListNode {
    var node = ListNode(3)
    node.next = ListNode(2)
    node.next!!.next = ListNode(0)
    node.next!!.next!!.next = ListNode(-4)
    node.next!!.next!!.next!!.next = node.next

    return node
}

