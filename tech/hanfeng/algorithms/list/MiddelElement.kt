package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode
import tech.hanfeng.algorithms.list.utils.printList

fun middleNode(head: ListNode?): ListNode? {
    var dummy : ListNode? = ListNode(0)
    dummy!!.next = head
    var slow = dummy
    var fast = dummy
    while(fast != null) {
        slow =slow!!.next
        fast = fast.next?.next
    }

    return slow
}

fun main() {
    var node = ListNode(3)
    node.next = ListNode(2)
    node.next!!.next = ListNode(0)
    printList(middleNode(node))
}
