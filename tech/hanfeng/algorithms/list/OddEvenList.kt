package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode
import tech.hanfeng.algorithms.list.utils.printList

fun oddEvenList(head : ListNode?) : ListNode? {
    if (head?.next?.next == null) {
        return head
    }

    var odd = head
    var even = head.next
    var evenHead = even

    while (even?.next != null) {
        odd!!.next = odd.next!!.next
        even.next = even.next?.next
        odd = odd.next
        even = even.next
    }

    odd?.next = evenHead
    return head
}

fun main() {
    var node = ListNode(3)
    node.next = ListNode(2)
    node.next!!.next = ListNode(0)
    node.next!!.next!!.next = ListNode(4)

    printList(oddEvenList(node))
}