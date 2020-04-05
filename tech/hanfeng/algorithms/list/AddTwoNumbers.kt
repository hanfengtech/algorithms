package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode
import tech.hanfeng.algorithms.list.utils.printList

fun addTwoNumbers(l1: ListNode?, l2 : ListNode?) : ListNode? {
    var dummy = ListNode(0)
    var cur : ListNode? = dummy
    var carry = 0
    var p = l1
    var q = l2

    while(p != null || q != null) {
        var sum = carry
        if (p != null) {
            sum += p.value
            p = p.next
        }
        if (q != null) {
            sum += q.value
            q = q.next
        }
        cur!!.next = ListNode(sum % 10)
        cur = cur.next
        carry = sum / 10
    }

    if (carry == 1) {
        cur?.next = ListNode(1)
    }

    return dummy.next
}

fun main() {

    var node = ListNode(2)
    node.next = ListNode(4)

    var node2 = ListNode(5)
    node2.next = ListNode(6)
    node2.next!!.next = ListNode(9)
    node2.next!!.next!!.next = ListNode(9)

    printList(addTwoNumbers(node, node2))
}