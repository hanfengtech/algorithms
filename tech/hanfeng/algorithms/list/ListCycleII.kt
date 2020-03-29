package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode
import tech.hanfeng.algorithms.list.utils.populateCycleList

fun detectCycle(head : ListNode?) : ListNode? {

    if (head?.next == null) {
        return null
    }

    var walker = head
    var runner = head

    while (runner != null || runner?.next != null) {
        walker = walker?.next
        runner = runner.next?.next
        if (walker == runner) {
            var walker2 = head
            while (walker != walker2) {
                walker = walker?.next
                walker2 = walker2?.next
            }

            return walker
        }
    }
    return null
}

fun main() {
    println(detectCycle(null)?.value)
    println(detectCycle(ListNode(0))?.value)
    var head = populateCycleList()
    println(detectCycle(head)?.value)

    var node = ListNode(1)
    node.next = ListNode(2)
    println(detectCycle(node)?.value)

    node = ListNode(1)
    node.next = node
    println(detectCycle(node)?.value)

}