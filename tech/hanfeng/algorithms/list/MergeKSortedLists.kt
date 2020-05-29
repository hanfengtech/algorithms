package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode
import java.util.*

fun mergeKLists(lists: Array<ListNode?>) : ListNode? {
    val dummyHead = ListNode(0)

    if (lists.isEmpty()) return dummyHead.next

    val priorityQueue = PriorityQueue<ListNode>{ a, b ->
        a.value - b.value
    }

    for (listHead in lists) {
        if (listHead != null)
            priorityQueue.offer(listHead)
    }

    var cur :ListNode? = dummyHead

    while(priorityQueue.isNotEmpty()) {
        val node = priorityQueue.remove()
        cur!!.next = node
        if (node.next != null) {
            priorityQueue.offer(node.next)
        }
        cur = cur.next
    }

    return dummyHead.next
}

fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(4)
    l1.next!!.next = ListNode(5)

    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next!!.next = ListNode(4)

    val l3 = ListNode(2)
    l3.next = ListNode(6)

    val list = arrayOf(l1, l2, l3, null)

    var cur = mergeKLists(list)

    while (cur != null) {
        print("${cur.value}")
        if (cur.next != null) {
            print("->")
        }
        cur = cur.next
    }
}