package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode

fun getIntersectionNode(headA : ListNode?, headB : ListNode?) : ListNode? {
    if (headA == null || headB == null) return null

    var a = headA
    var b = headB

    while (a != b) {
        a = if (a == null) headB else a.next
        b = if (b == null) headA else b.next
    }

    return a
}

fun main() {
    var a1 = ListNode(4)
    a1.next = ListNode(1)

    var node8 = ListNode(8)
    a1.next?.next = node8

    var b1 = ListNode(5)
    b1.next = ListNode(0)
    b1.next?.next = ListNode(1)

    b1.next?.next?.next = node8

    node8.next = ListNode(4)
    node8.next?.next = ListNode(5)

    println(getIntersectionNode(a1, b1)?.value)
}