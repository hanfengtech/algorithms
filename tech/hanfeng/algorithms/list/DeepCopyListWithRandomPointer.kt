package tech.hanfeng.algorithms.list


class RandomNode(var `val`: Int) {
    var next: RandomNode? = null
    var random: RandomNode? = null
}

fun printList(node : RandomNode?) {
    if (node == null)
        return

    var cur = node
    if (cur.next !== null) {
        while (cur?.next != null) {
            print("${cur?.`val`} -> ")
            cur = cur?.next
        }
    }
    println(cur?.`val`)
}

fun deepCopy(head : RandomNode?) : RandomNode? {
    if (head == null) {
        return null
    }

    var hashMap = HashMap<RandomNode, RandomNode>()

    var cur = head
    var dummyHead = RandomNode(0)
    var curCopy = dummyHead

    while(cur != null) {
        curCopy.next = RandomNode(cur.`val`)
        hashMap[cur!!] = curCopy.next!!
        cur = cur.next
        curCopy = curCopy.next!!
    }

    cur = head

    while (cur != null) {
        if (cur.random != null) {
            curCopy = hashMap[cur]!!
            curCopy.random = hashMap[cur.random!!]
        }
        cur = cur.next
    }

    return dummyHead.next
}

fun main() {
    var node = RandomNode(1)
    var node2 = RandomNode(2)
    node.random = node2
    node2.random = node2

    node.next = node2

    var node3 = RandomNode(1)

    printList(deepCopy(node))
    printList(deepCopy(null))
    printList(deepCopy(node3))
}