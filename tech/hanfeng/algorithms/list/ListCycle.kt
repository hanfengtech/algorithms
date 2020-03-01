package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode
import tech.hanfeng.algorithms.list.utils.populateCycleList

fun hasCycle(head : ListNode?) : Boolean {
    if (head == null) return false

    var walker = head
    var runner = head

    while (runner?.next != null && runner.next?.next != null) {
        walker = walker?.next
        runner = runner.next!!.next
        if (walker == runner) return true
    }
    return false
}

fun main() {
    var head = populateCycleList()
    print(hasCycle(head))

}