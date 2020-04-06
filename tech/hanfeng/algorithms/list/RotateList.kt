package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode
import tech.hanfeng.algorithms.list.utils.printList

fun rotateRight(head : ListNode?, k : Int) : ListNode? {
    if (head?.next == null || k == 0) {
        return head
    }

    var dummy = ListNode(0)
    dummy.next = head
    var fast = dummy
    var slow = dummy

    var count = 0
    while (fast?.next != null) {  // count number of nodes
        fast = fast.next!!
        count++
    }

    var pos = count - k % count

    for (i in 0 until pos) {   // go to the i - n % k
        slow = slow.next!!
    }

    fast?.next = dummy.next  // rotate list
    dummy.next = slow.next
    slow.next = null

    return dummy.next
}

fun main() {

    var node = ListNode(1)
    node.next = ListNode(2)

    node.next!!.next = ListNode(3)
    node.next!!.next!!.next = ListNode(4)
    node.next!!.next!!.next!!.next = ListNode(5)

    printList(rotateRight(node, 2))
}