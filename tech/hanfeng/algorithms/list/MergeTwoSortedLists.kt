package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode
import tech.hanfeng.algorithms.list.utils.printList

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var p1 = l1
    var p2 = l2
    var dummy = ListNode(0)
    var p : ListNode? = dummy

    while (p1 != null && p2 != null) {
        if (p1.value <= p2.value) {
            p!!.next = p1
            p1 = p1.next
        } else {
            p!!.next = p2
            p2 = p2.next
        }
        p = p.next
    }

    if (p1 != null)
        p!!.next = p1
    if (p2 != null)
        p!!.next = p2

    return dummy.next
}

fun mergeTwoListsR(l1: ListNode?, l2:ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1

    if (l1.value <= l2.value) {
        l1.next = mergeTwoListsR(l1.next, l2)
        return l1
    } else {
        l2.next = mergeTwoListsR(l1, l2.next)
        return l2
    }
}

fun main() {
    var node = ListNode(1)
    node.next = ListNode(2)
    node.next!!.next = ListNode(4)

    var node2 = ListNode(1)
    node2.next = ListNode(3)
    node2.next!!.next = ListNode(4)

    printList(mergeTwoLists(node, node2))
}