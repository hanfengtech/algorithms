package tech.hanfeng.algorithms.list

import tech.hanfeng.algorithms.list.utils.ListNode


fun isPalindrome(head : ListNode?) : Boolean {

    var slow = head
    var fast = head

    while (fast != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    println(slow?.value)

    var secondPart = reverseList(slow)

    var cur = head
    while (secondPart != null) {
        if (cur?.value != secondPart.value) {
            return false
        }
        cur = cur.next
        secondPart = secondPart.next
    }

    return true
}

fun main() {
    var node = ListNode(1)
    node.next = ListNode(2)
    node.next!!.next = ListNode(2)
    node.next!!.next!!.next = ListNode(1)
    println(isPalindrome(node))
}