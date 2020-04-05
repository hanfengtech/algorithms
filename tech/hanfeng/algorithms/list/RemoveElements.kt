package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode
import tech.hanfeng.algorithms.list.utils.printList

fun removeElements(head : ListNode?, target : Int) :  ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var cur : ListNode? = dummy

    while (cur?.next != null) {
        if (cur.next!!.value == target) {
            cur.next = cur.next!!.next
        } else {
            cur = cur.next
        }
    }

    return dummy.next
}

fun main() {
    var node = ListNode(3)
    node.next = ListNode(2)
    node.next!!.next = ListNode(0)
    node.next!!.next!!.next = ListNode(2)

    printList(removeElements(node, 2))
}