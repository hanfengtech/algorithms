package tech.hanfeng.algorithms.list.utils

fun printList(node: ListNode?) {
    if (node == null)
        return

    var cur = node
    if (cur.next !== null) {
        while (cur?.next != null) {
            print("${cur?.value} -> ")
            cur = cur?.next
        }
    }
    print(cur?.value)
}