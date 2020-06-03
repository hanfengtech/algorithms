package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode
import tech.hanfeng.algorithms.list.utils.printList

fun reverseList(head : ListNode?) : ListNode? {
    if (head?.next == null) {
        return head
    }

    var newHead = reverseList(head.next)
    head.next!!.next = head
    head.next = null

    return newHead
}

fun reverseListIt(head : ListNode?) : ListNode? {
    var newHead : ListNode? = null
    var cur = head
    var tmp : ListNode?

    while (cur != null) {
        tmp = cur.next
        cur.next = newHead
        newHead = cur
        cur = tmp
    }

    return newHead
}


fun reverseListR(head : ListNode?) : ListNode? {
    if (head?.next == null) return head

    val newHead = reverseListR(head.next)
    head.next!!.next = head
    head.next = null
    return newHead
}

fun main() {

    var node = ListNode(3)
    node.next = ListNode(2)
    node.next!!.next = ListNode(0)

    var newHead = reverseList(node)
    printList(newHead)

    println()
    printList(reverseListIt(newHead))
}


