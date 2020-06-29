package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode

fun reverseKGroup(head : ListNode?, k : Int) : ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var prev = dummy
    var cur = head

    while(cur != null) {
        var tail = cur
        var i = 0
        while(cur != null && i < k) {
            cur = cur.next
            i++
        }

        if (i != k) {
            prev.next = tail
        } else {
            prev.next = reverse(tail, k)
            prev = tail
        }
    }
    return dummy.next
}

fun reverse(head : ListNode?, k : Int) : ListNode? {
    var newHead : ListNode? = null
    var cur = head
    var count = 0
    while(cur != null && count++ < k) {
        val next = cur.next
        cur.next = newHead
        newHead = cur
        cur = next
    }
    return newHead
}

fun main() {
    var head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)

    tech.hanfeng.algorithms.list.utils.printList(reverseKGroup(head, 2))
}