package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode
import tech.hanfeng.algorithms.list.utils.printList

fun removeNthFromEnd(head : ListNode?, n : Int)  : ListNode? {

    if (n < 1 || head == null) {
        return head
    }

    val start : ListNode ?= ListNode(0)
    start!!.next = head

    var fast = start
    var slow = start

    var i = 0
    while (i++ <= n && fast != null) {
        fast = fast.next
    }

    if (i != n + 2) {
        return head
    }

    while(fast != null) {
        fast = fast.next
        slow = slow!!.next
    }

    slow!!.next = slow.next!!.next

    return start.next
}

fun main() {
    val node = ListNode(1)
    node.next = ListNode(2)
    node.next!!.next = ListNode(3)
    node.next!!.next!!.next = ListNode(4)
    node.next!!.next!!.next!!.next = ListNode(5)

    printList(removeNthFromEnd(node, 2))
}