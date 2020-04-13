package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode

fun deleteNode(node : ListNode?) {
    node?.value = node?.next!!.value
    node.next = node.next?.next
}

fun main() {
    var node = ListNode(3)
    node.next = ListNode(2)
    node.next!!.next = ListNode(0)

    deleteNode(node.next!!)
    tech.hanfeng.algorithms.list.utils.printList(node)
}